<template>
    <div v-if="isview">
        <div class="chart1">
            <div class="chart_class" ref="v_usage"></div>
        </div>
        <div v-if="d" class="chart1">
            <div class="chart_class" ref="d_usage"></div>
        
        </div>
        <div class="chart1">
            <div class="chart_class" ref="j_usage"></div>
        
        </div>
         <el-row type="flex" justify="center" align="middle">
          <el-col :span="10" >
              <div class="chart3">
                  <div class="chart_class" ref="cdr3_len"></div>
              </div>
          </el-col>
          <el-col :span="10" >
              <div class="chart3">
                  <div class="chart_class" ref="cdr3"></div>
              </div>
          </el-col>
        </el-row>
        <div v-if="d" class="chart4">
            <div class="chart_class" ref="v_d_j_usage"></div>
            
        </div>
        <div v-else class="chart2">
            <div class="chart_class1" ref="v_j_usage"></div>
        </div>
       
        
    </div>
  

</template>

<script>
import axios from 'axios'
import * as echarts from 'echarts/core'
import { BarChart, PieChart,SankeyChart,GraphChart,SunburstChart} from 'echarts/charts'
import { TitleComponent, TooltipComponent, GridComponent, LegendComponent, DatasetComponent, VisualMapComponent} from 'echarts/components'
import { CanvasRenderer } from 'echarts/renderers'
import { color } from 'echarts/core'
import { getView } from '../../../../api/view'
echarts.use(
  [
    TitleComponent,
    TooltipComponent,
    GridComponent,
    BarChart,
    PieChart,
    SankeyChart,
    GraphChart,
    SunburstChart,
    LegendComponent,
    DatasetComponent,
    CanvasRenderer,
    VisualMapComponent
  ]
)
export default {
    name: 'plot',
    props:{
        isview: {
            type:Boolean,
            default:true
        },
        filepath:{
            type:String,
            default:''
        }
    },
    data(){
        return{
            v_group:[],
            d_group:[],
            j_group:[],
            v_name:[],
            d_name:[],
            j_name:[],
            v_j_group:[],
            v_d_group:[],
            d_j_group:[],
            cdr3_group:[],
            cdr3_sun:{},
            diversity:[],
            node:[],
            line:[],
            d: false,
            chart_v_usage:null,
            chart_d_usage:null,
            chart_j_usage:null,
            chart_v_d_j_usage:null,
            chart_v_j_usage:null,
            chart_cdr3_len:null,
            chart_cdr3:null,
            loading:true,
        }
    },
    mounted(){
       
    },
    watch:{
        isview: function(a,b){
            if(a==false){
                console.log("dispose echars")
                this.v_group=[],
                this.d_group=[],
                this.j_group=[],
                this.v_name=[],
                this.d_name=[],
                this.j_name=[],
                this.v_j_group=[],
                this.v_d_group=[],
                this.d_j_group=[],
                this.cdr3_group=[],
                this.cdr3_sun={},
                this.diversity=[],
                this.node=[],
                this.line=[],
                this.d=false,

                this.chart_v_usage.dispose()
                this.chart_d_usage.dispose()
                this.chart_j_usage.dispose()
                this.chart_v_d_j_usage.dispose()
                this.chart_v_j_usage.dispose()
                this.chart_cdr3_len.dispose()
                this.chart_cdr3.dispose()
                
            }
            if(a==true){
                getView(this.filepath).then(res=>{
                this.v_group=res['v_group']
                this.d_group=res['d_group']
                this.j_group=res['j_group']
                this.cdr3_sun=res['cdr3_sun']
                if(res['type']=='a'){
                    this.d=false
                }
                else{
                    this.d=true
                }
                if(this.d_group['freq'].length>1){
                     for (var i in this.d_group['d']){
                         
                        this.d_name.push({
                            name:this.d_group['d'][i],
                            value:this.d_group['freq'][i]
                        })
                    }
                    if(this.d){
                    for (var i in res['v_d_group']['v']){
                        this.v_d_group.push({
                            source:res['v_d_group']['v'][i],
                            target:res['v_d_group']['d'][i],
                            value:res['v_d_group']['freq'][i]
                        })
                    }
                    for (var i in res['d_j_group']['d']){
                        this.d_j_group.push({
                            source:res['d_j_group']['d'][i],
                            target:res['d_j_group']['j'][i],
                            value:res['d_j_group']['freq'][i]
                        })
                    }
                    this.$nextTick(()=>{
                        this.init_d_usage()
                        this.init_v_d_j_usage()
                    })
                    }
                    else{
                    this.$nextTick(()=>{
                    this.init_v_j_usage()  
                })
                } 
                }
                else{
                    this.$nextTick(()=>{
                    this.init_v_j_usage()  
                })
                }
                for (var i in this.v_group['v']){
                    this.v_name.push({
                        name:this.v_group['v'][i],
                        value:this.v_group['freq'][i]
                    })
                }
                for (var i in this.j_group['j']){
                    this.j_name.push({
                        name:this.j_group['j'][i],
                        value:this.j_group['freq'][i]
                    })
                }
                for (var i in res['v_j_group']['v']){
                    this.v_j_group.push({
                        source:res['v_j_group']['v'][i],
                        target:res['v_j_group']['j'][i],
                        value:res['v_j_group']['freq'][i]
                    })
                }  
                this.cdr3_group=res['cdr3_group']
                this.diversity=res['diversity']
                this.init_v_usage()
                this.init_j_usage()
                this.init_cdr3_len()
                this.init_cdrs()
                this.loading=false
                })
            }
            if(a==false){
                this.$forceUpdate()
            }
            
        }
    },
    methods:{
        init_v_usage(){
            this.chart_v_usage=echarts.init(this.$refs.v_usage)
            let option = {
                title:{
                    text:'V gene segment usage',
                    padding:[20,0,0,100]
                },
                tooltip:{
                    trigger:'axis',
                    axisPointer:{
                        type:'shadow'
                    }
                },
                xAxis:[
                    {
                        type: 'category',
                        data: this.v_group['v'],
                        axisTick:{
                            alignWithLabel:true
                        },
                        axisLabel:{
                            interval:0,
                            rotate: 90
                        }
                    }
                ],
                yAxis:[
                    {
                        type:'value',
                        axisLabel: {
                            show: true,
                            interval: 'auto',
                            formatter: '{value}'
                        }
                    }
                ],
                series:[
                    {
                        name:'v gene frequency',
                        type:'bar',
                        barWidth:'60%',
                        data:this.v_group['freq'],
                    }
                ],
                visualMap: {
                    show: false,
                    min: 0,
                    max: 0.12,
                    inRange: {
                        color: ['rgb(40,120,181)','rgb(154,201,219)','rgb(248,172,140)','rgb(200,36,25)'],
                    }
                },
            }
            this.chart_v_usage.setOption(option)
            let temp=this
            window.addEventListener("resize",function(){
                temp.chart_v_usage.resize()
            })
        },
        init_d_usage(){
            this.chart_d_usage=echarts.init(this.$refs.d_usage)
            let option = {
                title:{
                    text:'D gene segment usage',
                    padding:[20,0,0,100]
                    
                },
                tooltip:{
                    show:true,
                    trigger:'axis',
                    axisPointer:{
                        type:'shadow'
                    }
                },
                xAxis:[
                    {
                        type: 'category',
                        data: this.d_group['d'],
                        axisTick:{
                            alignWithLabel:true
                        },
                        axisLabel:{
                            interval:0,
                            rotate: 90
                        }
                    }
                ],
                yAxis:[
                    {
                        type:'value',
                        axisLabel: {
                            show: true,
                            interval: 'auto',
                            formatter: '{value}'
                        }
                    }
                ],
                series:[
                    {
                        name:'d gene frequency',
                        type:'bar',
                        barWidth:'60%',
                        data:this.d_group['freq'],
                    }
                ],
                visualMap: {
                    show: false,
                    min: 0,
                    max: 0.6,
                    inRange: {
                        color: ['rgb(40,120,181)','rgb(154,201,219)','rgb(248,172,140)','rgb(200,36,25)'],
                    }
                },
            }
            this.chart_d_usage.setOption(option)
            let temp=this
            window.addEventListener("resize",function(){
                temp.chart_d_usage.resize()
            })
            
        },
        init_j_usage(){
            this.chart_j_usage=echarts.init(this.$refs.j_usage)
            let option = {
                title:{
                    text:'J gene segment usage',
                    padding:[20,0,0,100]
                    
                },
                tooltip:{
                    show:true,
                    trigger:'axis',
                    axisPointer:{
                        type:'shadow'
                    }
                },
                xAxis:[
                    {
                        type: 'category',
                        data: this.j_group['j'],
                        axisTick:{
                            alignWithLabel:true
                        },
                        axisLabel:{
                            interval:0,
                            rotate: 90
                        }
                    }
                ],
                yAxis:[
                    {
                        type:'value',
                        axisLabel: {
                            show: true,
                            interval: 'auto',
                            formatter: '{value}'
                        }
                    }
                ],
                series:[
                    {
                        name:'d gene frequency',
                        type:'bar',
                        barWidth:'60%',
                        data:this.j_group['freq'],
                    }
                ],
                visualMap: {
                    show: false,
                    min: 0,
                    max: 0.12,
                    inRange: {
                        color: ['rgb(40,120,181)','rgb(154,201,219)','rgb(248,172,140)','rgb(200,36,25)'],
                    }
                },
            }
            this.chart_j_usage.setOption(option)
            let temp=this
            window.addEventListener("resize",function(){
                temp.chart_j_usage.resize()
            })
        },
        init_v_d_j_usage(){
            this.chart_v_d_j_usage=echarts.init(this.$refs.v_d_j_usage)
            
            this.line=this.v_d_group.concat(this.d_j_group)
            this.v_name.forEach(function(node){
                node.symbolSize = node.value*150;
                 node.itemStyle={
                     color:'rgb(240,152,140)'
                     }
                node.label = {
                    normal: {
                        show: true,
                    }
                }
            })
            this.d_name.forEach(function(node){
                node.symbolSize = node.value*150;
                node.itemStyle={color:'rgb(162,169,208)'}
                node.label = {
                    normal: {
                        show: true,
                    }
                }
            })
            this.j_name.forEach(function(node){
                node.symbolSize = node.value*150;
                node.itemStyle={color:'rgb(150,204,203)'}
                node.label = {
                    normal: {
                        show: true,
                    }
                }
            })
            this.node=this.v_name.concat(this.d_name).concat(this.j_name)
            this.line.forEach(function (link) {
                link.lineStyle={
                    normal:{
                        width:link.value*200,
                        opacity:0.5
                    }
                }
            })
            let option = {
                title:{
                    text:'V-D-J gene segment combination frequency',
                    padding:[0,0,0,100]
                    
                },
                tooltip:{
                    show:true,
                    trigger:'item',
                    axisPointer:{
                        type:'shadow'
                    }
                },
                animationDurationUpdate: 1500,
                animationEasingUpdate: 'quinticInOut',
                series:[
                    {
                        name:'v-d-j frequency',
                        type:'sankey',
                        focusNodeAdjacency: 'allEdges',
                        data:this.node,
                        links:this.line,
                        label:{
                            normal: {
                                position: 'right',
                                formatter: '{b}'
                            }
                        },
                    }
                ]
            }
            this.chart_v_d_j_usage.setOption(option)
            let temp=this
            window.addEventListener("resize",function(){
                temp.chart_v_d_j_usage.resize()
            })

        },
        init_v_j_usage(){
            this.chart_v_j_usage=echarts.init(this.$refs.v_j_usage)
            
            this.line=this.v_j_group
            this.v_name.forEach(function(node){
                node.symbolSize = node.value*150;
                 node.itemStyle={
                     color:'rgb(240,152,140)'
                     }
                node.label = {
                    normal: {
                        show: true,
                    }
                }
            })
            this.j_name.forEach(function(node){
                node.symbolSize = node.value*150;
                node.itemStyle={color:'rgb(162,169,208)'}
                node.label = {
                    normal: {
                        show: true,
                    }
                }
            })
            this.node=this.v_name.concat(this.j_name)
            this.line.forEach(function (link) {
                link.lineStyle={
                    normal:{
                        width:link.value*200,
                        opacity:0.5
                    }
                }
            })
            let option = {
                title:{
                    text:'V-J gene segment combination frequency',
                    padding:[20,0,0,100]
                    
                },
                tooltip:{
                    show:true,
                    trigger:'item',
                    axisPointer:{
                        type:'shadow'
                    }
                },
                animationDurationUpdate: 1500,
                animationEasingUpdate: 'quinticInOut',
                grid:{
                    x:25,
                    y:45,
                    x2:5,
                    y2:20,
                    borderWidth:1
                },
                series:[
                    {
                        name:'v-j frequency',
                        type:'graph',
                        layout: 'circular',
                        circular: {
                            rotateLabel: true
                        },
                        data:this.node,
                        links:this.line,
                        label:{
                            normal: {
                                position: 'right',
                                formatter: '{b}'
                            }
                        },
                        
                        itemStyle:{
                            normal: {
                                borderCap:'square',
                            }
                        },
                        lineStyle: {
                            normal: {
                                color: {
                                    type: 'linear',
                                    x: 0,
                                    y: 0,
                                    x2: 0,
                                    y2: 1,
                                    colorStops: [{
                                        offset: 0, color: 'rgb(162,169,208)'
                                    }, {
                                        offset: 1, color: 'rgb(240,152,140)'
                                    }],
                                    globalCoord: false
                                },
                                curveness: 0.3,
                                opacity:0.2,
                                bordeJoin:'miter'
                            }
                        }
                    }
                ]
            }
            this.chart_v_j_usage.setOption(option)
            let temp=this
            window.addEventListener("resize",function(){
                temp.chart_v_d_usage.resize()
            })
        },
        init_cdr3_len(){
            var legen_name=[]
            var mySeries=[]
            var colors=['rgb(252,186,132)','rgb(248,192,141)','rgb(246,197,149)','rgb(243,204,159)','rgb(239,210,168)',
            'rgb(236,215,176)','rgb(234,222,185)','rgb(231,227,196)','rgb(227,234,205)','rgb(224,239,213)',
            'rgb(213,236,217)','rgb(195,225,213)','rgb(175,214,210)','rgb(157,205,208)','rgb(137,194,205)',
            'rgb(119,183,201)','rgb(99,172,198)','rgb(81,160,196)','rgb(61,149,193)','rgb(43,139,189)']
            var j=0
            for( var i in this.cdr3_group){
                if(i!='lengthNum'){
                    legen_name.push(i)
                    if(i!='other'){
                         mySeries.push({
                            name:i,
                            data:this.cdr3_group[i],
                            type:'bar',
                            stack: 'Ad',
                            barWidth : 12,
                            itemStyle:{
                                normal:{color:colors[j]},
                            }
                        })
                        j=j+1
                    }
                    else{
                        mySeries.push({
                        name:i,
                        data:this.cdr3_group[i],
                        type:'bar',
                        stack: 'Ad',
                        barWidth : 12,
                        itemStyle:{
                            normal:{color:"rgb(158,158,158)"},
                        }
                    })

                    }
                    
                }
            }
             this.chart_cdr3_len=echarts.init(this.$refs.cdr3_len)
             let option = {
                title:{
                    text:'CDR3 length distribution',
                    padding:[20,0,0,0]
                    
                },
                tooltip:{
                    show:true,
                    trigger:'item',
                    axisPointer:{
                        type:'shadow'
                    }
                },
                legen:{
                    show:true,
                    type:'plain',
                    itemWidth:15,  
                    itemHeight:15, 
                },
                xAxis:[
                    {
                        type: 'category',
                        data: this.cdr3_group['lengthNum'],
                        axisLabel:{
                            interval:5,
                        },
                        nameLocation:'middle'
                    }
                ],
                yAxis:[
                    {
                        type:'value',
                        axisLabel: {
                            show: true,
                            interval: 'auto',
                            formatter: '{value}'
                        }
                    }
                ],
                series:mySeries
            }
            var legend={ 
                type:'scroll',
                data: legen_name,
                right: 10,
                bottom: 10,
                itemWidth:12,  
                itemHeight:12,
                textStyle:{
                    fontSize:10,
                }
            }
            option.legend=legend
            this.chart_cdr3_len.setOption(option)
            let temp=this
            window.addEventListener("resize",function(){
                temp.chart_cdr3_len.resize()
            })
        },
        init_cdrs(){
            this.chart_cdr3=echarts.init(this.$refs.cdr3)
            let option = {
                title:{
                    text:'Clonotype distribution',
                    padding:[20,0,0,50]
                    
                },
                tooltip:{
                    show:true,
                    trigger:'item',
                    axisPointer:{
                        type:'shadow'
                    }
                },
                series:[
                    {
                        name:'CDR3',
                        type:'sunburst',
                        radius: [60, '90%'],
                        data:[
                            {
                                name:'1',
                                value:this.cdr3_sun['1']
                            },
                            {
                                name:'2',
                                value:this.cdr3_sun['2']
                            },
                            {
                                name:'3+',
                                children:[
                                    {
                                        name: 'Q1',
                                        value:this.cdr3_sun['Q'][4],
                                        children:[
                                            {
                                                name: this.cdr3_sun['top'][0],
                                                value:this.cdr3_sun['top_num'][0],
                                                label:{
                                                    show:false
                                                }

                                            },
                                            {
                                                name: this.cdr3_sun['top'][1],
                                                value:this.cdr3_sun['top_num'][1],
                                                label:{
                                                    show:false
                                                }
                                            },
                                            {
                                                name: this.cdr3_sun['top'][2],
                                                value:this.cdr3_sun['top_num'][2],
                                                label:{
                                                    show:false
                                                }
                                            },
                                            {
                                                name: this.cdr3_sun['top'][3],
                                                value:this.cdr3_sun['top_num'][3],
                                                label:{
                                                    show:false
                                                }
                                            },
                                            {
                                                name: this.cdr3_sun['top'][4],
                                                value:this.cdr3_sun['top_num'][4],
                                                label:{
                                                    show:false
                                                }
                                            }
                                        ]
                                    },
                                     {
                                        name: 'Q2',
                                        value:this.cdr3_sun['Q'][3]
                                    },
                                     {
                                        name: 'Q3',
                                        value:this.cdr3_sun['Q'][2]
                                    },
                                     {
                                        name: 'Q4',
                                        value:this.cdr3_sun['Q'][1]
                                    },
                                     {
                                        name: 'Q5',
                                        value:this.cdr3_sun['Q'][0]
                                    }
                                ]
                            }
                        ],
                    }
                ],
                visualMap: {
                    show: false,
                    min: 0,
                    max: 1000,
                    inRange: {
                        color: ['rgb(154,201,219)','rgb(248,172,140)','rgb(200,36,25)'],
                    }
                },
            }
            this.chart_cdr3.setOption(option)
            let temp=this
            window.addEventListener("resize",function(){
                temp.chart_cdr3.resize()
            })
        }
        
    }

}

</script>
<style scoped>
.chart1{
width: 100%!important;
height: 300px!important;
margin-top: 1%;
margin-bottom: 1%;
}
.chart2{
    width: 100%!important;
    height: 850px!important;
    margin-top:1%;
    margin-bottom:20%;
}
.chart3{
    width: 100%!important;
    height: 300px!important;
    margin-top: 1%;
    margin-bottom: 1%;
}
.chart4{
     width: 100%!important;
    height: 700px!important;
    margin-top:2%;
    margin-bottom:20%;
}
.chart_class{
    width: 100%!important;
    height: 100%!important;
}
.chart_class1{
    width: 100%!important;
    height: 100%!important;
}
</style>