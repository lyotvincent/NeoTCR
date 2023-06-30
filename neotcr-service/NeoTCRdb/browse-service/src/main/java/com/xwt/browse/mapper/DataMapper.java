package com.xwt.browse.mapper;
import com.xwt.thrift.browse.CDR3TCR;
import com.xwt.thrift.browse.McPAS;
import com.xwt.thrift.browse.NeoTCR;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface DataMapper {
    @Select("select * from neoTCR")
    List<NeoTCR> getAllTCR();

    @Select("#{selectStr}")
    List<NeoTCR> getTCRStr(@Param("selectStr") String selectStr);

    @Select({"<script>",
            "select * from neoTCR where 1 = 1",
            "<if test='antigen != null and antigen.size() > 0'>",
            " and antigen in ",
            "<foreach collection='antigen' item='item' index='index' open='(' separator=',' close=')'>",
            "(#{item})",
            "</foreach>",
            "</if>",
            "<if test='aminoAcidExchange != null and aminoAcidExchange.size() > 0'>",
            " and aminoAcidExchange in ",
            "<foreach collection='aminoAcidExchange' item='item' index='index' open='(' separator=',' close=')'>",
            "(#{item})",
            "</foreach>",
            "</if>",
            "<if test='hlaAllele != null and hlaAllele.size() > 0'>",
            " and hlaAllele in ",
            "<foreach collection='hlaAllele' item='item' index='index' open='(' separator=',' close=')'>",
            "(#{item})",
            "</foreach>",
            "</if>",
            "<if test='traCDR3 != null and traCDR3.size() > 0'>",
            " and traCDR3 in ",
            "<foreach collection='traCDR3' item='item' index='index' open='(' separator=',' close=')'>",
            "(#{item})",
            "</foreach>",
            "</if>",
            "<if test='trav != null and trav.size() > 0'>",
            " and trav in ",
            "<foreach collection='trav' item='item' index='index' open='(' separator=',' close=')'>",
            "(#{item})",
            "</foreach>",
            "</if>",
            "<if test='traj != null and traj.size() > 0'>",
            " and traj in ",
            "<foreach collection='traj' item='item' index='index' open='(' separator=',' close=')'>",
            "(#{item})",
            "</foreach>",
            "</if>",
            "<if test='trbCDR3 != null and trbCDR3.size() > 0'>",
            " and trbCDR3 in ",
            "<foreach collection='trbCDR3' item='item' index='index' open='(' separator=',' close=')'>",
            "(#{item})",
            "</foreach>",
            "</if>",
            "<if test='trbv != null and trbv.size() > 0'>",
            " and trbv in ",
            "<foreach collection='trbv' item='item' index='index' open='(' separator=',' close=')'>",
            "(#{item})",
            "</foreach>",
            "</if>",
            "<if test='trbj != null and trbj.size() > 0'>",
            " and trbj in ",
            "<foreach collection='trbj' item='item' index='index' open='(' separator=',' close=')'>",
            "(#{item})",
            "</foreach>",
            "</if>",
            "<if test='tumor != null and tumor.size() > 0'>",
            " and tumor in ",
            "<foreach collection='tumor' item='item' index='index' open='(' separator=',' close=')'>",
            "(#{item})",
            "</foreach>",
            "</if>",
            "</script>"})
    List<NeoTCR> getTCR(@Param("antigen") List<String> antigen,
                        @Param("aminoAcidExchange") List<String> aminoAcidExchange,
                        @Param("hlaAllele") List<String> hlaAllele,
                        @Param("traCDR3") List<String> traCDR3,
                        @Param("trav") List<String> trav,
                        @Param("traj") List<String> traj,
                        @Param("trbCDR3") List<String> trbCDR3,
                        @Param("trbv") List<String> trbv,
                        @Param("trbj") List<String> trbj,
                        @Param("tumor") List<String> tumor);

    @Select({"<script>",
            "select * from neoTCR where traCDR3 in ",
            "<foreach collection='cdrs' item='item' index='index' open='(' separator=',' close=')'>",
            "(#{item})",
            "</foreach>",
            " or trbCDR3 in ",
            "<foreach collection='cdrs' item='item' index='index' open='(' separator=',' close=')'>",
            "(#{item})",
            "</foreach>",
            "</script>"
    })
    List<NeoTCR> getNeo(@Param("cdrs") List<String> cdrs);

    @Select({"<script>",
            "select * from cdr3 where CDR3 in ",
            "<foreach collection='cdrs' item='item' index='index' open='(' separator=',' close=')'>",
            "(#{item})",
            "</foreach>",
            "</script>"
    })
    List<CDR3TCR> getCDR3TCR(@Param("cdrs") List<String> cdrs);

    @Select({"<script>",
            "select * from mcpas where CDR3A in ",
            "<foreach collection='cdrs' item='item' index='index' open='(' separator=',' close=')'>",
            "(#{item})",
            "</foreach>",
            " or CDR3B in ",
            "<foreach collection='cdrs' item='item' index='index' open='(' separator=',' close=')'>",
            "(#{item})",
            "</foreach>",
            "</script>"
    })
    List<McPAS> getMcPAS(@Param("cdrs") List<String> cdrs);
}
