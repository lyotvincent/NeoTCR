<template>
  <div>
    <el-tabs v-model="activeName" type="border-card" class="mytabs"  @tab-click="handleTabClick">
      <el-tab-pane class="tab_pane1 tab_pane" name="annotation" label="Annotation">
        <div class="box-card1">
        <el-form ref="form" :model="form" :label-suffix="':'" label-width="140px" >
          <el-form-item label="Upload File" :required='false'>
            <div>
              <el-row>
                <el-col style="width: 140px;">
              <el-upload
              class="upload-demo"
              action="http:// /service/upload/transfile" 
              accept="application/gzip,text/plain"
              :on-preview="handlePreview"
              :before-remove="beforeRemove"
              :before-upload="beforeUpload"
              multiple
              :limit="2"
              :on-exceed="handleExceed"
              :file-list="fileList"
              :on-success="onSuccess"
              :on-error="onError"
              >
              <div>
               <el-tooltip class="item" effect="dark" content=".fastq or .fastq.gz or .txt" placement="bottom-start">
              <el-button type="primary">Choose file</el-button>
               </el-tooltip>
               </div>
            </el-upload>
          </el-col>
            <el-col style="width: 60px; margin-top: 3px;">
              <el-dropdown @command="example">
                <el-button type="primary" >
                  Example<i class="el-icon-arrow-down el-icon--right"></i>
                </el-button>
                <el-dropdown-menu slot="dropdown">
                  <el-dropdown-item command="a">TRA</el-dropdown-item>
                  <el-dropdown-item command="b">TRB</el-dropdown-item>
                </el-dropdown-menu>
              </el-dropdown>
          </el-col>
          </el-row>
          </div>
          </el-form-item>
          <el-form-item label="Library Building Method" :required='true' label-width="auto">
            <el-radio-group v-model="form.func">
              <el-radio label="Multiplex PCR"></el-radio>
              <el-radio label="5'RACE"></el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item v-if="form.func=='Multiplex PCR'" label="Type" :required="true"> 
            <el-radio-group v-model="form.type">
              <el-radio label="DNA"></el-radio>
              <el-radio label="RNA"></el-radio>
            </el-radio-group>
          </el-form-item>
          <el-row>
              <el-form-item label="TCR Chain" :required='true' label-width="140px">
            <el-radio-group v-model="form.chain">
              <el-radio label="TRA"></el-radio>
              <el-radio label="TRB"></el-radio>
            </el-radio-group>
          </el-form-item>
          </el-row>
          <el-row >
            <el-col :span="3">
              <el-form-item label="UMI">
                <el-switch v-model="form.umi"></el-switch>
              </el-form-item>
            </el-col>
            <el-col :span="15">
               <el-form-item v-if="form.umi" label="UMI Info">
                 <el-col :span="10">
                   <el-input v-model="form.umi_info" ></el-input>
                 </el-col>
              </el-form-item>
            </el-col>
          </el-row>
          <el-button v-loading="loading" type="primary" @click="goAnnotation">Start Analyze</el-button>
          <el-button type="primary" @click="clearFile">Clear</el-button>
        </el-form>
        <el-row style="margin-top:2%;">
             <el-button v-if='getResult' type="primary" @click="getMixcr">Download Annotation Info</el-button>
            <el-button v-if='getResult' type="primary" @click="getMixcrCDR3">CDR3 Alignment</el-button>
          <el-button v-if='getResult' type="primary" @click="getView">Visualization</el-button>
        </el-row>
      </div>
      </el-tab-pane>
      <el-tab-pane class="tab_pane" name="cdr3" label="CDR3 Alignment">
        <div class="box-card2">
          <el-row>
            <el-card class="stpe1">
            <div slot="header" class="clearfix">
              <span class="step_head">Step1:Upload</span>
            </div>
          <el-form label-position="top" ref="form1" :model="form1" :label-suffix="':'" label-width="400px">
              <el-form-item label="Paste CDR3 list to analyse">
              <el-input class="cdr3_input" v-model="form1.cdr3" placeholder="Please input CDR3 sequences" type="textarea" :rows="5" ></el-input>
            </el-form-item>
            <div>
              <p>upload file:</p>
              <div >
              <el-upload
              class="upload-demo "
              action="http:// /service/upload/txtfile" 
              accept=".txt"
              :on-preview="handlePreviewTXT"
              :before-remove="beforeRemoveTXT"
              :before-upload="beforeUploadTXT"
              multiple
              :limit="1"
              :on-exceed="handleExceedTXT"
              :file-list="txtfileList"
              :on-success="onSuccessTXT"
              :on-error="onErrorTXT"
              >
              <el-button type="primary">Choose file</el-button>
            </el-upload>
            </div>
            <el-button class="clear_button" type="primary" @click="handleClear">Clear</el-button>
            
            </div>
          </el-form>
          </el-card>
              <el-card class="stpe1">
            <div slot="header" class="clearfix">
              <span class="step_head">Step2:Select</span>
            </div>
            <div>
            <el-checkbox :indeterminate="isIndeterminate" v-model="checkAll" @change="handleCheckAllChange">all</el-checkbox>
            <div style="margin: 15px 0;"></div>
            <el-checkbox-group v-model="checked" @change="handleCheckedChange">
              <el-checkbox v-for="db in dbs" :label="db" :key="db">{{db}}</el-checkbox>
            </el-checkbox-group>
            </div>

              </el-card>
              <el-card class="stpe1">
                <div slot="header" class="clearfix">
              <span class="step_head">Step3:Run</span>
            </div>
            <div>The following analysis will be performed based on your choice:</div>
            <el-button type="primary" @click="getCDR3" class="search_button">Search</el-button>
              </el-card>
          </el-row>
          
          <div class="cdr3_result">
            <div class="table1">
              <div class="dbName">
                <i class="el-icon-s-data dbIcon"></i><span class="db_span">NeoTCR</span><el-button type="primary" icon="el-icon-download" round @click="downloadN"></el-button>
              </div>
                <el-table id="table_data1" :data="tableData1" border style="width: 100%;" v-loading="loading1">
                    <el-table-column prop="tumor" label="Tumor" width="auto"></el-table-column>
                    <el-table-column prop="antigen" label="Gene" width="70%"></el-table-column>
                    <el-table-column prop="aminoAcidExchange" :label="'Amino\nAcid\nExchange'" width="80%"></el-table-column>
                    <el-table-column label="Neoepitope" width="140">
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
                    <el-table-column prop="pubMedID" :label="'PubMed\nID'" width="125%">
                        <template slot-scope="scope">
                            <a :href="'https://pubmed.ncbi.nlm.nih.gov/'+scope.row.href" target="_blank">{{scope.row.pubMedID}}</a>
                        </template>
                    </el-table-column>
                </el-table>
            </div>
            <div class="table2">
              <div class="dbName">
                <i class="el-icon-s-data dbIcon"></i><span class="db_span">VDJdb</span><el-button type="primary" icon="el-icon-download" round @click="downloadV"></el-button>
              </div>
                <el-table id="table_data2" :data="tableData2" border style="width: 100%;" v-loading="loading2">
                    <el-table-column prop="Gene" label="Gene" ></el-table-column>
                    <el-table-column prop="CDR3" label="CDR3" ></el-table-column>
                    <el-table-column prop="V" label="V" ></el-table-column>
                    <el-table-column prop="J" label="J" ></el-table-column>
                    <el-table-column prop="MHC" :label="'MHC'" ></el-table-column>
                    <el-table-column prop="Epitope" label="Epitope" ></el-table-column>
                    <el-table-column prop="Epitope_Gene" :label="'Epitope\nGene'" ></el-table-column>
                    <el-table-column prop="Epitope_Species" :label="'Epitope\nSpecies'" ></el-table-column>
                    <el-table-column prop="Reference" label="Reference" >
                        <template slot-scope="scope">
                          <a v-if="scope.row.hrefType==0" :href="'https://pubmed.ncbi.nlm.nih.gov/'+scope.row.href" target="_blank">{{scope.row.Reference}}</a>
                        </template>
                    </el-table-column>
                </el-table>
            </div>
            <div class="table3">
              <div class="dbName">
                <i class="el-icon-s-data dbIcon"></i><span class="db_span">McPAS-TCR</span><el-button type="primary" icon="el-icon-download" round @click="downloadM"></el-button>
              </div>
              <el-table id="table_data3" :data="tableData3" border style="width:100%;" v-loading="loading3">
                <el-table-column prop="CDR3A" :label="'CDR3\nalpha'"></el-table-column>
                <el-table-column prop="CDR3B" :label="'CDR3\nbeta'"></el-table-column>
                <el-table-column prop="species" label="Species"></el-table-column>
                <el-table-column prop="category" label="Category"></el-table-column>
                <el-table-column prop="antigen" :label="'Antigen\nprotein'"></el-table-column>
                <el-table-column prop="protein" :label="'Protein\nID'"></el-table-column>
                <el-table-column prop="epitope" :label="'Epitope\npeptide'"></el-table-column>
                <el-table-column prop="mhc" label="MHC"></el-table-column>
                <el-table-column prop="trav" label="TRAV"></el-table-column>
                <el-table-column prop="traj" label="TRAJ"></el-table-column>
                <el-table-column prop="trbv" label="TRBV"></el-table-column>         
                <el-table-column prop="trbd" label="TRBD"></el-table-column>
                <el-table-column prop="trbj" label="TRBJ"></el-table-column>
                <el-table-column prop="pubmed" :label="'PubMed\nID'">
                  <template slot-scope="scope">
                    <a :href="'https://pubmed.ncbi.nlm.nih.gov/'+scope.row.pubmed" target="_blank">{{scope.row.pubmed}}</a>
                  </template>
                </el-table-column>
              </el-table>
            </div>
          </div>
        </div>
      </el-tab-pane>
    </el-tabs>  
    <plot :filepath="filePath" :isview="view"></plot>
  </div>
</template>

<script>
import plot from '../components/Plot.vue'
import { getUMIAnalyse,getAnalyse,getDNAAnalyse,delFile,downFile,conversion,searchTXTNeo,searchTXTVDJ,searchTXTMcPAS } from '../../../../api/analyse'
import { getCDR3, getTCR,getAllCDR3,getNeo,getCDR3TCR,getMcPAS } from '../../../../api/browse'
 import FileSaver from 'file-saver'
 import * as XLSX from 'xlsx'
 import{ json2csv } from 'json2csv'
 const dbsOptions=['NeoTCR','VDJdb','McPAS-TCR']
export default {
    name:"upload",
    components: {
      plot
    },
    data(){
        return{
          activeName: 'annotation',
          checkAll:false,
          checked:[],
          dbs:dbsOptions,
          isIndeterminate:false,
          fileList:[],
          txtfileList:[],
          uptxtfileList:[],
          responseList:[],
          loading:false,
          loading1: false,
          loading2: false,
          loading3:false,
          tableData1: [],
          tableData2:[],
          tableData3:[],
          getResult:false,
          view:false,
          filePath:'',
          form:{
            umi:false,
            umi_info: '',
            func:'',
            type:'',
            chain:''
          },
          form1:{},
          rules:{
            func:[
              {required:true,message:'Please select the Building Method',trigger:'blur'}
              ]
          },
          result_txt:'',
          isExample:false,
        }
    },
    mounted(){
      window.addEventListener("unload", (e) => this.unloadHandler(e));
    },
    destroyed() {
    window.removeEventListener("unload", (e) => this.unloadHandler(e));
  },
    beforeRouteLeave(to, from, next) {
      if(this.responseList.length==0){
        next()
      }
      else{
         this.$confirm('It will delete the upload file and annotation result.', 'Warn', {
          confirmButtonText: 'ok',
          cancelButtonText: 'cancel',
          type: 'warning'
        }).then(()=>{
          this.destroyedFile()
          this.$message({
            type: 'success',
            message: 'delete success!'
          })
          next()
        }).catch(() => {
          next(false)
        })
      }
     
    },
    methods: {
      example(e){
        this.isExample=true
        if(e=='a'){
          this.$message("Example of TRA")
          this.filePath="/root/example/outpath_a/full_clones.txt"
          this.form.func="5'RACE"
          this.form.chain="TRA"
          this.fileList=[{name:"TRA_R1.fastq.gz",status: "success"},{name:"TRA_R2.fastq.gz",status: "success"}]
        }
        if(e=='b'){
          this.$message("Example of TRB")
          this.filePath="/root/example/outpath_b/full_clones.txt"
          this.form.func="5'RACE"
          this.form.chain="TRB"
          this.fileList=[{name:"TRB_R1.fastq.gz",status: "success"},{name:"TRB_R2.fastq.gz",status: "success"}]
        }
      },
      clearFile(e){
        console.log("clearFile")
        this.view=false
        this.fileList=[]
        this.txtfileList=[]
        this.uptxtfileList=[]
        this.responseList=[] 
        this.getResult=false
        this.filePath=''
        this.result_txt=''
        this.form={
            umi:false,
            umi_info: '',
            func:'',
            type:'',
            chain:''
          }
        this.isExample=false
      },
      handleTabClick(tab,event){
        if(tab.label=="CDR3 Alignment"){
          this.view=false
          this.$forceUpdate()
        }
      },
      handleCheckAllChange(val) {
        this.checked = val ? dbsOptions : [];
        this.isIndeterminate = false;
      },
      handleCheckedChange(value) {
        let checkedCount = value.length;
        this.checkAll = checkedCount === this.dbs.length;
        this.isIndeterminate = checkedCount > 0 && checkedCount < this.dbs.length;
      },
      
      handleExceed(files, fileList) {
        this.$alert('You can only upload 2 files each time.','File Error')
      },
      handleExceedTXT(files, fileList){
        this.$alert('You can only upload 1 files each time.','File Error')
      },
      beforeRemove(file, fileList) {
        
      },
      beforeRemoveTXT(file, fileList) {
      },
      handlePreview(file) {
      },
      handlePreviewTXT(file) {
      },
      beforeUpload (file) {
        const isGZ = file.type === 'application/gzip'||'fastq'
        const isTXT = file.type === 'text/plain'
        const isLt20M = file.size / 204800 / 204800 < 200
        
        if (!isLt20M) {
            this.$alert('The file size cannot exceed 200MB.','Upload Failed')
            return false;
        }
        if (isGZ) {
          const nottxt = this.uptxtfileList.length === 0
          if(!nottxt){
            this.$alert('You can only upload one type file.')
            return false;
          }
          return isGZ && isLt20M && nottxt;
          
        }
        if(isTXT){
          const notfastq = this.responseList.length === 0
          if(!notfastq){
            this.$alert('You can only upload one type file.')
            return false;
          }
          return isTXT && isLt20M && notfastq;
        }
        else{
          this.$alert('Please upload a file in fastq\\fastq.gzip\\txt format.','File Format Error')
          return false;
        }
      },
      beforeUploadTXT(file){
        const isTXT = file.type === 'text/plain'
        const isLt20M = file.size / 204800 / 204800 < 200
        if (!isTXT) {
          this.$alert('Please upload a file in TXT format.','File Format Error')
            return false;
        }
        if (!isLt20M) {
            this.$alert('The file size cannot exceed 200MB.','Upload Failed')
            return false;
        }
        return isTXT && isLt20M;
      },
      onSuccess(response,file,fileList){
        if(file.raw.type == "text/plain"){
          this.uptxtfileList=fileList
        }
        else{
          this.responseList=fileList

        }
      },
      onSuccessTXT(response,file,fileList){
        this.txtfileList=fileList
      },
      onError(err,file,fileList){
         this.$alert('Network error. Please upload again.','Upload File Error')
      },
      onErrorTXT(err,file,fileList){
         this.$alert('Network error. Please upload again.','Upload File Error')
      },
      handleClear(){
        console.log("handleClear")
        this.txtfileList=[]
        this.checkAll=false,
        this.checked=[]
        this.form1.cdr3=''
      },
      goAnnotation(){
        const isTXT=this.uptxtfileList.length > 0
        if(isTXT){
          console.log("txt analysis")
          this.filePath = this.uptxtfileList[0].response.virtualPath+this.uptxtfileList[0].response.fileName
          this.view=true
          
          this.getResult=true
          return true;
        }
        if(this.isExample){
          this.getResult=true
          return true;
        }
        console.log("fastq analysis")
        if(this.responseList.length!=2){
            this.$alert('Please upload paired-end sequencing','Annotation Failed')
            return false;
        }
        if(this.form.chain==''){
          this.$alert('Please choose TCR Chain.')
          return false;
        }
        if(this.form.func==''){
          this.$alert('Please choose the library building method','Annotation Failed')
            return false;
        }
        else if(this.form.func=='Multiplex PCR'){
          if(this.form.type==''){
            this.$alert('Please choose data type','Annotation Failed')
            return false;
          }
          else if(this.form.type=='DNA'){
            this.loading=true
            this.$alert('<div style="width:850px; word-break: break-all !important;">You may download results by visiting the URL below.<br/>URL:http://neotcrdb.com:8083/service/upload/download?fileName='+this.responseList[0].response.fileName.split(".")[0]+'.txt</div>','TIP',{
              confirmButtonText:'OK',
              customClass:'message_box_alert',
              dangerouslyUseHTMLString:true,
            })
            const formData=new FormData()
            formData.append('filename1',this.responseList[0].response.virtualPath+this.responseList[0].response.fileName)
            formData.append('filename2',this.responseList[1].response.virtualPath+this.responseList[1].response.fileName)
            formData.append('chain',this.form.chain)
            getDNAAnalyse(formData).then((res)=>{
              this.loading=false
              this.getResult=true
              if(res!=''){
                this.getResult=true
                this.filePath=res
              }
              else{
                this.$message({
                  type: 'info',
                  message: 'Annotation Failed'
                })
              }
            })
          }
          else{
            this.loading=true
            this.$alert('<div style="width:850px; word-break: break-all !important;">You may download results by visiting the URL below.<br/>URL:http://neotcrdb.com:8083/service/upload/download?fileName='+this.responseList[0].response.fileName.split(".")[0]+'.txt</div>','TIP',{
              confirmButtonText:'OK',
              customClass:'message_box_alert',
              dangerouslyUseHTMLString:true,
            })
            const formData=new FormData()
            formData.append('filename1',this.responseList[0].response.virtualPath+this.responseList[0].response.fileName)
            formData.append('filename2',this.responseList[1].response.virtualPath+this.responseList[1].response.fileName)
            formData.append('chain',this.form.chain)
            getAnalyse(formData).then((res)=>{
              this.loading=false
              if(res!=''){
                this.getResult=true
                this.filePath=res
              }
              else{
                this.$message({
                  type: 'info',
                  message: 'Annotation Failed'
                })
              }
            })
          }
        }
        else{
          if(this.form.umi){
            if(this.form.umi_info==""){
              this.$alert('Please input UMI info','Annotation Failed')
              return false;
            }
            this.loading=true
            this.$alert('<div style="width:850px; word-break: break-all !important;">You may download results by visiting the URL below.<br/>URL:http://neotcrdb.com:8083/service/upload/download?fileName='+this.responseList[0].response.fileName.split(".")[0]+'.txt</div>','TIP',{
              confirmButtonText:'OK',
              customClass:'message_box_alert',
              dangerouslyUseHTMLString:true,
            })
            const formData=new FormData()
            formData.append('filename1',this.responseList[0].response.virtualPath+this.responseList[0].response.fileName)
            formData.append('filename2',this.responseList[1].response.virtualPath+this.responseList[1].response.fileName)
            formData.append('umi',this.form.umi_info)
            formData.append('chain',this.form.chain)
            getUMIAnalyse(formData).then((res)=>{
              this.loading=false
              if(res!=''){
                this.getResult=true
                this.filePath=res
              }
              else{
                this.$message({
                  type: 'info',
                  message: 'Annotation Failed'
                })
              }
            })
          }
          else{
            this.loading=true
            this.$alert('<div style="width:850px; word-break: break-all !important;">You may download results by visiting the URL below.<br/>URL:http://neotcrdb.com:8083/service/upload/download?fileName='+this.responseList[0].response.fileName.split(".")[0]+'.txt</div>','TIP',{
              confirmButtonText:'OK',
              customClass:'message_box_alert',
              dangerouslyUseHTMLString:true,
            })
            const formData=new FormData()
            formData.append('filename1',this.responseList[0].response.fileName)
            formData.append('filename2',this.responseList[1].response.fileName)
            formData.append('chain',this.form.chain)
            getAnalyse(formData).then((res)=>{
              this.loading=false
              if(res!=''){
                this.getResult=true
                this.filePath=res
              }
              else{
                this.$message({
                  type: 'info',
                  message: 'Annotation Failed'
                })
              }
            })

          }
        }  
      },
      getFastqc(){
      },
      getMixcr(){
        if(this.result_txt==''){
          conversion(this.filePath).then((res)=>{
          this.result_txt=res
          var str=Object.keys(res).join("\t")
          str+='\n'
          for (var key in res['count']){
            str+=res['count'][key]+'\t'
            str+=res['freq'][key]+'\t'
            str+=res['cdr3nt'][key]+'\t'
            str+=res['cdr3aa'][key]+'\t'
            str+=res['v'][key]+'\t'
            str+=res['d'][key]+'\t'
            str+=res['j'][key]+'\t'
            str+=res['c'][key]+'\t'
            str+=res['fr1'][key]+'\t'
            str+=res['cdr1'][key]+'\t'
            str+=res['fr2'][key]+'\t'
            str+=res['cdr2'][key]+'\t'
            str+=res['fr3'][key]+'\t'
            str+=res['fr4'][key]+'\n'
          }
          var blob = new Blob([str],{type: "text/plain;charset=utf-8"})
         saveAs(blob,'sample.txt')
        })
        }
      },
      getMixcrCDR3(){
        if(this.result_txt==''){
          conversion(this.filePath).then((res)=>{
            this.result_txt=res
            var values = Object.values(res['cdr3aa']);
            var values_str=values.join("\n")
            this.form1.cdr3=values_str

            this.$confirm("The CDR3 sequences are automatically pasted at Step 1 of the CDR3 Alignment page. Please choose the database to be aligned at Step 2, and then run the program at Step 3."+"<br>"+"* Press the “OK” button to go to the CDR3 Alignment page.","Tips",{
          dangerouslyUseHTMLString: true,
          confirmButtonText: 'ok',
          cancelButtonText: 'cancel',
          customClass: 'cdr3-message'
        }).then(() => {
            this.activeName = 'cdr3'
            this.view = false
        }).catch(()=>{
          console.log('cancel')
        })
            })
        }
        else{
          var values = Object.values(this.result_txt['cdr3aa']);
            var values_str=values.join("\n")
            this.form1.cdr3=values_str

            this.$confirm("The CDR3 sequences are automatically pasted at Step 1 of the CDR3 Alignment page. Please choose the database to be aligned at Step 2, and then run the program at Step 3."+"<br>"+"* Press the “OK” button to go to the CDR3 Alignment page.","Tips",{
          dangerouslyUseHTMLString: true,
          confirmButtonText: 'ok',
          cancelButtonText: 'cancel',
          customClass: 'cdr3-message'
        }).then(() => {
            this.activeName = 'cdr3'
            this.view = false
        }).catch(()=>{
          console.log('cancel')
        })
        }
        
      },
      getView(){
        this.view=true
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
      getCDR3(){
        if(this.checked.length==0){
          this.$alert('Please select a scope for this search.','CDR3 Search Failed')
          return false;
        }
        if(this.form1.cdr3!=null&&this.form1.cdr3!=''){
          for(var i=0;i<this.checked.length;i++){
            switch (this.checked[i]) {
              case "NeoTCR":
                this.loading1=true
                console.log("neotcr")
                getNeo(this.form1.cdr3).then((res)=>{
                  this.tableData1=res
                  for (var i in this.tableData1){
                      if(this.tableData1[i]['pubMedID']){
                          this.tableData1[i]['href']=this.tableData1[i]['pubMedID'].split(" ")[1]
                      }
                      if(this.tableData1[i]['neoformat']){
                          this.tableData1[i]['neolist']=this.handleNeoFormat(this.tableData1[i]['neoformat'])
                      }
                      if(this.tableData1[i]['traCDR3format']){
                          [this.tableData1[i]['tracolorlist'],this.tableData1[i]['trastrlist']]=this.handleCDR3Format(this.tableData1[i]['traCDR3format'])
                      }
                      if(this.tableData1[i]['trbCDR3format']){
                          [this.tableData1[i]['trbcolorlist'],this.tableData1[i]['trbstrlist']]=this.handleCDR3Format(this.tableData1[i]['trbCDR3format'])
                      }
                  }
                  this.loading1=false
                })
                break;
              case "VDJdb":
                console.log("VDJdb")
                this.loading2=true
                getCDR3TCR(this.form1.cdr3).then((res)=>{
                  this.tableData2=res
                  for(var i in this.tableData2){
                    if(this.tableData2[i]['Reference']){
                      this.tableData2[i]['href']=this.tableData2[i]['Reference'].split(":")[1]
                      if(this.tableData2[i]['Reference'].split(":")[0]=="PMID"){
                        this.tableData2[i]['hrefType']=0
                      }
                      else {
                        this.tableData2[i]['hrefType']=1
                      }
                    }
                  }
                  this.loading2=false
                })
                break;
              case "McPAS-TCR":
                console.log("McPAS-TCR")
                this.loading3=true
                getMcPAS(this.form1.cdr3).then((res)=>{
                  this.tableData3=res
                  this.loading3=false
                })
                break;
              default:
                break;
            }
          }
        }
        else if(this.txtfileList.length>0){
          for(var i=0;i<this.checked.length;i++){
            switch (this.checked[i]) {
              case "NeoTCR":
                this.loading1=true
                searchTXTNeo(this.txtfileList[0].response).then((res)=>{
                  this.tableData1=res
                  for (var i in this.tableData1){
                      if(this.tableData1[i]['pubMedID']){
                          this.tableData1[i]['href']=this.tableData1[i]['pubMedID'].split(" ")[1]
                      }
                      if(this.tableData1[i]['neoformat']){
                          this.tableData1[i]['neolist']=this.handleNeoFormat(this.tableData1[i]['neoformat'])
                      }
                      if(this.tableData1[i]['traCDR3format']){
                          [this.tableData1[i]['tracolorlist'],this.tableData1[i]['trastrlist']]=this.handleCDR3Format(this.tableData1[i]['traCDR3format'])
                      }
                      if(this.tableData1[i]['trbCDR3format']){
                          [this.tableData1[i]['trbcolorlist'],this.tableData1[i]['trbstrlist']]=this.handleCDR3Format(this.tableData1[i]['trbCDR3format'])
                      }
                  }
                  this.loading1=false
                  
                })
                break;
              case "VDJdb":
                console.log("VDJdb")
                this.loading2=true
                searchTXTVDJ(this.txtfileList[0].response).then((res)=>{
                  this.tableData2=res
                  for(var i in this.tableData2){
                    if(this.tableData2[i]['Reference']){
                      this.tableData2[i]['href']=this.tableData2[i]['Reference'].split(":")[1]
                    }
                  }
                  this.loading2=false
                })
                break;
              case "McPAS-TCR":
                console.log("McPAS-TCR")
                this.loading3=true
                searchTXTMcPAS(this.txtfileList[0].response).then((res)=>{
                  this.tableData3=res
                  this.loading3=false
                })
                break;
              default:
                break;
            }
          }
        }
        else{
          this.$alert("Please input the CDR3 sequence or upload the file.","CDR3 Search Failed")
        }
        

      },
      handleSizeChange(val) {
        this.currentPage=1
        this.pageSize=val
      },
      handleCurrentChange(val) {
        this.currentPage=val
      },
    async unloadHandler(e) {
      await this.handleGoLog();
    },
    handleGoLog(){
      if(this.responseList.length>0){
      }
      
    },
    destroyedFile(e){
        for( var i=0;i<this.responseList.length;i++)
        {
          delFile(this.responseList[i].response.fileName).then((res)=>{
          })
        }
      },
    downloadN(e){
      console.log('download')
       var wb = XLSX.utils.table_to_book(document.querySelector('#table_data1'))
         /* get binary string as output */
         var wbout = XLSX.write(wb, { bookType: 'xlsx', bookSST: true, type: 'array' })
         try {
             FileSaver.saveAs(new Blob([wbout], { type: 'application/octet-stream' }), 'neotcr.xlsx')
         } catch (e) { if (typeof console !== 'undefined') console.log(e, wbout) }
         return wbout

    },
    downloadV(e){
      console.log('download')
        var wb = XLSX.utils.table_to_book(document.querySelector('#table_data2'))
         /* get binary string as output */
         var wbout = XLSX.write(wb, { bookType: 'xlsx', bookSST: true, type: 'array' })
         try {
             FileSaver.saveAs(new Blob([wbout], { type: 'application/octet-stream' }), 'vdjdb.xlsx')
         } catch (e) { if (typeof console !== 'undefined') console.log(e, wbout) }
         return wbout

    },
    downloadM(e){
      console.log('download')
        var wb = XLSX.utils.table_to_book(document.querySelector('#table_data3'))
         var wbout = XLSX.write(wb, { bookType: 'xlsx', bookSST: true, type: 'array' })
         try {
             FileSaver.saveAs(new Blob([wbout], { type: 'application/octet-stream' }), 'mcpas-tcr.xlsx')
         } catch (e) { if (typeof console !== 'undefined') console.log(e, wbout) }
         return wbout

    }
    }
}

</script>
<style>

.message_box_alert{
  width: 850px !important;
}
.cdr3-message{
  width: 570px !important;
  padding-top: 10px;
  padding-bottom: 20px !important;
}
</style>
<style scoped>

.item {
      margin: 4px;
}

.dbIcon{
  color: #409EFF;
  margin-right: 5px;
}
.dbName{
  font-size:1.2em;
  color: rgb(89, 93, 97);
  margin-bottom: 10px;
}
.db_span{
  margin-right:10px;
}
.mytabs{
  margin: 2%; 
}
.tab_pane1{
  height: 430px;
}
.tab_pane{
  padding: 20px;
}
.box-card{
    height: 360px;
}
.clear_button{
  margin-top:10px;
}
.search_button{
  margin: 10px auto;
}
.table1{
  margin-top: 10px;
}
.table2{
  margin-top: 20px;
}
.table3{
  margin-top:20px;
}
.cdr3_input{
  width:100%;
}
.step_head{
  font-size: 1.2em;
}
.stpe1{
  margin: 1%;
  float:left;
  width: 30%;
  height: 460px;
  margin-bottom: 10px;
}
.font0{
    /* 普通 */ 
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
</style>