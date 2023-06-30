<template>
  <div>
      <el-card class="box-card">
        <div>
        <h2 class="title-h2">Results</h2>
        </div>
        <el-container>
            <el-header style="height: 30px;">
                <div>
                    <div style="display: inline-block;">
                        <el-pagination
                            @size-change="handleSizeChange"
                            @current-change="handleCurrentChange"
                            :current-page="currentPage"
                            :page-sizes="[25,50,100]"
                            :page-size="pageSize"
                            layout="total, sizes, prev, pager, next, jumper"
                            :total="totalPage">
                            </el-pagination>
                    </div>
                    <div v-if="canDownload" style="margin-left: 10px;display: inline-block;">
                        <el-tooltip class="item" effect="dark" content="You can only download the results after searching the database." placement="bottom-start">
                            <el-button type="primary" icon="el-icon-download" round @click="downloadResult"></el-button>
                        </el-tooltip>
                    </div>
        </div>
            </el-header>
            <el-main>
                <el-table 
                    id="table_result"
                    :data="tableData.slice((currentPage-1)*pageSize,currentPage*pageSize)" 
                    border 
                    style="width: 100%"
                    stripe 
                    max-height="1400"
                    v-loading="loading" 
                    :header-cell-style="{color: 'rgb(60, 60, 60)', background: 'rgb(245,245,245)', padding: '0px'}"
                    :row-style="{height: '0', width: '0'}"
                    :cell-style="{padding: '0px'}"
                    :header-row-style="{padding: '0px'}"
                    :resizable="false"
                    fit>
                    <el-table-column prop="tumor" label="Tumor" width="auto"></el-table-column>
                    <el-table-column prop="antigen" label="Gene" width="70%"></el-table-column>
                    <el-table-column prop="aminoAcidExchange" :label="'Amino\nAcid\nExchange'" width="80%">
                    </el-table-column>
                    <el-table-column label="Neoepitope" width="140px">
                        <template slot-scope="scope">
                            <span v-for="(item,index) in scope.row.neolist" :key="index">
                                <span v-for="(value,key,index) in item" :key="index">
                                    <span :class="[{'font0': (key=='0')},{'font1': (key=='1')},{'font2': (key=='2')}]">{{value}}</span>
                                </span>
                            </span>
                        </template>
                    </el-table-column>
                    <el-table-column prop="trav" label="TRAV" width="100%"></el-table-column>
                    <el-table-column prop="traj" label="TRAJ" width="100%"></el-table-column>
                    <el-table-column label="TRA_CDR3" width="170%">
                        <template slot-scope="scope">
                            <span v-for="(item,index) in scope.row.tracolorlist" :key="index">
                                <span :class="[{'font0': (item==0)},{'font3': (item==3)},{'font4': (item==4)},{'font5': (item==5)}]">{{scope.row.trastrlist[index]}}</span>
                            </span>
                        </template>
                    </el-table-column>
                    <el-table-column prop="trbv" label="TRBV" width="100%"></el-table-column>
                    <el-table-column prop="trbj" label="TRBJ" width="100%"></el-table-column>
                    <el-table-column label="TRB_CDR3" width="170%">
                        <template slot-scope="scope">
                            <span v-for="(item,index) in scope.row.trbcolorlist" :key="index">
                                <span :class="[{'font0': (item==0)},{'font3': (item==3)},{'font4': (item==4)},{'font5': (item==5)}]">{{scope.row.trbstrlist[index]}}</span>
                            </span>
                        </template>
                    </el-table-column>
                    <el-table-column prop="cellType" :label="'Cell\nType'" width="50%"></el-table-column>
                    <el-table-column prop="hlaAllele" :label="'HLA\nAllele'" width="90%"></el-table-column>
                    <el-table-column prop="source" label="Source" width="65%"></el-table-column>
                    <el-table-column prop="pubMedID" label="PubMed ID" width="125%">
                        <template slot-scope="scope">
                            <a :href="'https://pubmed.ncbi.nlm.nih.gov/'+scope.row.href" target="_blank">{{scope.row.pubMedID}}</a>
                        </template>
                    </el-table-column>
                    
                </el-table>

            </el-main>
        </el-container>
        
      </el-card>
  </div>
</template>

<script>
import {getAllTCR,getTCR,getTheTCR} from '../../../../api/browse'
import FileSaver from 'file-saver'
import * as XLSX from 'xlsx'
export default {
    name: "result_card",
    data(){
        return{
            totalPage: 0,
            currentPage: 1,
            tableData: [],
            pageSize:25,
            loading: true,
            canDownload: false,
        }
    },
    created(){
        this.getAllTCR()
        
    },
    
    mounted () {
        this.$EventBus.$on("submit",(data)=>{
            this.onSubmit(data)
        })
    },
    beforeDestroy () {
        this.$EventBus.$off("submit")
    },
    methods: {
        getAllTCR(){
            getAllTCR().then((response)=>{
                this.tableData = response
                this.totalPage=this.tableData.length
                for (var i in this.tableData){
                    if(this.tableData[i]['pubMedID']){
                        this.tableData[i]['href']=this.tableData[i]['pubMedID'].split(" ")[1]
                        this.tableData[i]['pubMedID']=this.tableData[i]['pubMedID'].replace(',', '\n')
                    }
                    if(this.tableData[i]['neoformat']){
                        this.tableData[i]['neolist']=this.handleNeoFormat(this.tableData[i]['neoformat'])
                    }
                    if(this.tableData[i]['traCDR3format']){
                        [this.tableData[i]['tracolorlist'],this.tableData[i]['trastrlist']]=this.handleCDR3Format(this.tableData[i]['traCDR3format'])
                    }
                    if(this.tableData[i]['trbCDR3format']){
                        [this.tableData[i]['trbcolorlist'],this.tableData[i]['trbstrlist']]=this.handleCDR3Format(this.tableData[i]['trbCDR3format'])
                    }
                    if(this.tableData[i]['hlaAllele']){
                        this.tableData[i]['hlaAllele']=this.tableData[i]['hlaAllele'].replace(',', '\n')
                    }
                    if(this.tableData[i]['trav']){
                        this.tableData[i]['trav']=this.tableData[i]['trav'].replace(',', '\n')
                    }
                    if(this.tableData[i]['trbv']){
                        this.tableData[i]['trbv']=this.tableData[i]['trbv'].replace(',', '\n')
                    }
                }
                this.loading=false
            })
        },
        handleNeoFormat(val){
            var list=[]
            list = val.split(";")
            var dic=[]
            if(list.length>1){
                for(var i=0;i<list.length;i++){
                    if(i%2==0){ 
                        dic.push({0:list[i]})
                    }
                    else{
                        dic.push({1:list[i]})
                    }
                }
            }
            else{
                list=val.split(":")
                if(list.length>1){
                    for(var i=0;i<list.length;i++){
                        if(i%2==0){ 
                            dic.push({0:list[i]})
                        }
                        else{
                            dic.push({2:list[i]})
                        }
                    }
                }
                else{
                    dic.push({0:val})
                }
            }
            return dic
        },
        handleCDR3Format(val){
            var color_list=[0]
            var str_list=[]
            var temp=""
            if(val=='n.a.'){
                str_list.push(val)
                return [color_list,str_list]
            }
            for(var i=0;i<val.length;i++){
                if(val[i]>='A'&&val[i]<='Z'){
                    temp=temp+val[i]
                }
                else{
                    switch(val[i]){
                        case ':':
                            color_list.push(3)
                            break
                        case ';':
                            color_list.push(4)
                            break
                        case ',':
                            color_list.push(0)
                            break
                        case '.':
                            color_list.push(5)
                            break
                    }
                    str_list.push(temp)
                    temp=""
                }
            }
            str_list.push(temp)
            return [color_list,str_list]
        },
        handleSizeChange(val) {
            this.currentPage=1
            this.pageSize=val
        },
        handleCurrentChange(val) {
            this.currentPage=val
        },
        onSubmit(e){
            console.log('data',e)
            this.loading=true
            if(e['antigen'].length==0&&e['aminoAcidExchange'].length==0&&e['hlaAllele'].length==0&&e['traCDR3'].length==0&&e['traj'].length==0&&e['trav'].length==0
            &&e['trbCDR3'].length==0&&e['trbj'].length==0&&e['trbv'].length==0&&e['tumor'].length==0){
                this.getAllTCR()
                this.canDownload = false
            }
            else{
                var formData=new FormData()
                formData.append("antigen",e['antigen'])
                formData.append("aminoAcidExchange",e['aminoAcidExchange'])
                formData.append("hlaAllele",e['hlaAllele'])
                formData.append("tumor",e['tumor'])
                formData.append("trav",e['trav'])
                formData.append("traj",e['traj'])
                formData.append("traCDR3",e['traCDR3'])
                formData.append("trbv",e['trbv'])
                formData.append("trbj",e['trbj'])
                formData.append("trbCDR3",e['trbCDR3'])
                console.log(formData)
                getTheTCR(formData).then((response)=>{
                console.log(response)
                this.tableData = response
                this.totalPage=this.tableData.length
                for (var i in this.tableData){
                    if(this.tableData[i]['pubMedID']){
                        this.tableData[i]['href']=this.tableData[i]['pubMedID'].split(" ")[1]
                    }
                    if(this.tableData[i]['neoformat']){
                        this.tableData[i]['neolist']=this.handleNeoFormat(this.tableData[i]['neoformat'])
                    }
                    if(this.tableData[i]['traCDR3format']){
                        [this.tableData[i]['tracolorlist'],this.tableData[i]['trastrlist']]=this.handleCDR3Format(this.tableData[i]['traCDR3format'])
                    }
                    if(this.tableData[i]['trbCDR3format']){
                        [this.tableData[i]['trbcolorlist'],this.tableData[i]['trbstrlist']]=this.handleCDR3Format(this.tableData[i]['trbCDR3format'])
                    }
                }
                console.log(this.tableData)
                this.loading=false
                this.canDownload = true
                })
            }
        },
        downloadResult(e){
            console.log('download')
            if(!this.canDownload){
                return false;
            }
            var temp = this.pageSize
            this.pageSize = this.tableData.length;
            this.$nextTick(function()
            {
                var wb = XLSX.utils.table_to_book(document.querySelector('#table_result'))
            /* get binary string as output */
            var wbout = XLSX.write(wb, { bookType: 'xlsx', bookSST: true, type: 'array' })
            try {
                FileSaver.saveAs(new Blob([wbout], { type: 'application/octet-stream' }), 'NeoTCR_BrowseResults.xlsx')
            } catch (e) { if (typeof console !== 'undefined') console.log(e, wbout) }
            this.pageSize = temp
            return wbout
            })
        }
    }
}

</script>
<style lang="css" scoped>
.box-card{
    margin: 2%;
}
.font0{

}
.font1{
    /* 下划线 */
    color: rgb(255,0,0);
    text-decoration: underline;
}
.font2{
    /* 删除线+下划线 */
    color: rgb(255,0,0);
    text-decoration: underline line-through;
}
.font3{
    /* 蓝 */
    color: rgb(0,176,240);

}
.font4{
    /* 红 */
    color: rgb(255,0,0);
}
.font5{
    /* 绿 */
    color: rgb(0,176,80);
}

::v-deep .el-table--striped .el-table__body tr.el-table__row--striped td {
    background: rgb(128,128,128);
  }

.title-h2{
    font-size: 24px;
    color: rgb(81, 81, 81);
    font-weight: bold;
}

</style>