namespace py analyse.api

service AnalyseService{
    bool getAnalyse(1:string filename1,2:string filename2,3:string outpath,4:string chain);
    bool getDNAAnalyse(1:string filename1,2:string filename2,3:string outpath,4:string chain);
    bool getUMIAnalyse(1:string filename1,2:string filename2,3:string umi,4:string outpath,5:string chain);
    string conversion(1:string fileName);
    bool exampleTRA();
    bool exampleTRB();
}