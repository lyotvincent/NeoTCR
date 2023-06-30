<template>
<div>
  <div class="overlay">
    <div id="pageintro" class="hoc clear"> 
      <!-- ################################################################################################ -->
      <article>
        <h1 class="heading welcome">Welcome to NeoTCR</h1>
        <p class="postscript">A database for neoantigen-specific TCR repertoires</p>
        <footer>
        </footer>
      </article>
      <div align="center">
        <el-button type="primary" round style="width:30%;" @click="JumpBrowse" class="home_button">Browse</el-button>
        <el-button type="primary" round style="width:30%;" @click="JumpAnalysis" class="home_button">Analyze</el-button>
      </div>
      <!-- ################################################################################################ -->
    </div>
  </div>
    <div class="wrapper row3">
    <main class="hoc container clear"> 
      <figure class="hoc container clear imgroup"> 
    <!-- ################################################################################################ -->
    <figcaption class="sectiontitle">
      <p class="heading underline font-x2">Introduction</p>
    </figcaption>
      <div id='write'  class=''>
        <p>
          <strong><span>NeoTCR</span></strong>
          <span> is an immunoinformatic database of T-cell receptor (TCR) sequences with neoantigen specificities. The primary goal of NeoTCR is to facilitate access to existing information on neoantigen-specific TCRs, such as the neoepitope that it recognizes and binds, the relating somatic mutation, the HLA contexts, and so on. NeoTCR allows for fuzzy or accurate database searching based on different criteria. Besides, NeoTCR also provides useful web-based tools for comprehensive analysis of TCR sequencing data that users upload. These tools could help users to: (I) annotate the TCR sequences, including the V/(D)/J gene segment, CDR3 sequence, TCR repertoire clonality, and so on. (II) visualize the feature of TCR repertoires, including V/(D)/J gene segment counts and usage, CDR3 length and clonotype distribution, and so on. (III) blast CDR3 sequences with NeoTCR to label the known neoantigen-specific TCRs, and with other databases (e.g. VDJdb and McPAS-TCR) to find out the bystander viral-specific. NeoTCR will serve as a valuable platform to study the role of neoantigen-associated T-cells in anti-tumor immunity and further improve the understanding of biological functions and applications of neoantigen-specific TCRs.
          </span></p>
          
          <p><img src="../../../../src/assets/css/image/home-figure1.jpg" alt="home-figure1" style="zoom:50%;" /></p>
          <p><img src="../../../../src/assets/css/image/home-figure2.jpg" alt="home-figure2" style="zoom:50%;" /></p>
          <p>&nbsp;</p>
          <figcaption class="sectiontitle">
      <p class="heading underline font-x2">Latest News</p>
    </figcaption>
          <p>
            <span> NeoTCR database is now officially online in November 2022. NeoTCR database was updated in December 2022 and January 2023. </span>
          </p>
          <figcaption class="sectiontitle">
      <p class="heading underline font-x2">Contact</p>
    </figcaption>
          <p>
            *Weijun Zhou, Zhujiang Hospital of Southern Medical University, weijun@smu.edu.cn<br>
            *Kankan Wang, Ruijin Hospital Affiliated to Shanghai Jiao Tong University School of Medicine, kankanwang@shsmu.edu.cn <br>
            *Jian Liu, Centre for Bioinformatics and Intelligent Medicine, Nankai University, jianliu@nankai.edu.cn
          </p>
        </div>
    
  </figure>

    </main>
  </div>
 
</div>
</template>

<script>

export default {
    name: "home",
    data() {
      return {}
    },
    methods: {
      JumpAnalysis () {
        this.$router.push('/annotation')
      },
      JumpBrowse () {
        this.$router.push('/Browse')
      }
    }
}

</script>
<style scoped>
.welcome{
  /* color: rgb(219, 114, 68); */
  /* font-size: 4em!important; */
}
.home_button{
  font-size: 1.2em;
}
.postscript{
  font-size: 1.5em;
}
#write { font-size: 1.1em;line-height: 1.5em;text-align: justify; margin: 0px auto; height: auto; width: inherit; word-break: normal; overflow-wrap: break-word; position: relative; white-space: normal; overflow-x: visible; padding-top: 0px; }
/* #write.first-line-indent p { text-indent: 2em; }
#write.first-line-indent li p, #write.first-line-indent p * { text-indent: 0px; }
#write.first-line-indent li { margin-left: 2em; } */
</style>