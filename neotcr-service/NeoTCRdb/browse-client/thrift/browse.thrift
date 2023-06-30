#包名
namespace java com.xwt.thrift.browse

#定义新抗原数据
struct NeoTCR{
    1:string tumor,
    2:string source,
    3:string cellType,
    4:string antigen,
    5:string aminoAcidExchange,
    6:string neoepitope,
    7:string hlaAllele,
    8:string trav,
    9:string traj,
    10:string traCDR3,
    11:string trbv,
    12:string trbj,
    13:string trbCDR3,
    14:string pubMedID,
    15:string neoformat,
    16:string traCDR3format,
    17:string trbCDR3format
}

#定义VDJ db数据形式
struct CDR3TCR{
    1:string Gene,
    2:string CDR3,
    3:string V,
    4:string J,
    5:string MHC,
    6:string Epitope,
    7:string Epitope_Gene,
    8:string Epitope_Species,
    9:string Reference
}

#定义McPAS-TCR数据类型
struct McPAS{
    1:string CDR3A,
    2:string CDR3B,
    3:string species,
    4:string category,
    5:string antigen,
    6:string protein,
    7:string epitope,
    8:string mhc,
    9:string trav,
    10:string traj,
    11:string trbv,
    12:string trbd,
    13:string trbj,
    14:string pubmed
}

#定义查询接口
service BrowseService{
    list<NeoTCR> getAllTCR();
    list<NeoTCR> getTCRStr(1:string selectStr);
    list<NeoTCR> getTCR(1:list<string> antigen,2:list<string> aminoAcidExchange,3:list<string> hlaAllele,4:list<string> traCDR3,5:list<string> trav,6:list<string> traj,7:list<string> trbCDR3,8:list<string> trbv,9:list<string> trbj,10:list<string> tumor);
    list<NeoTCR> getNeo(1:list<string> cdrs);
    list<CDR3TCR> getCDR3TCR(1:list<string> cdrs);
    list<McPAS> getMcPAS(1:list<string> cdrs);

}