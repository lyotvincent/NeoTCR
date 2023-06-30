<template>
  <div>
      <el-card  class="box-card">
        <h1 id='browse'>Browse</h1>
        <h4 id='1each-entry-in-neotcr-contains-one-tcr-sequence-harboring-the-following-information'>1.Each entry in NeoTCR contains one TCR sequence harboring the following information:</h4>
        <!-- <p>&nbsp;</p> -->
        <p><img src="../../../../assets/css/image/browse-w.png" alt="image-20220629160751482" style="zoom: 90%;" /></p>
        <!-- <p>&nbsp;</p> -->
        <p>(1) <em>Tumor</em>: Disease in which the TCR sequence was identified. </p>
        <p>(2) <em>Gene, Amino Acid Exchange,</em> and <em>Neoepitope</em>: These fields describe the characteristics of TCR-associated neoantigens: <em>Antigen</em> - the antigen protein that the TCR target; <em>Amino Acid Exchange</em> - the amino acid somatic from the corresponding wild-type antigen protein, including single nucleotide mutation (SNM), insertion and deletion (indel), fusion, and splicing; <em>Neoepitope</em> - the amino acid sequence of neoepitope that TCR binds and recognizes, the mutated amino acid is underscored.</p>
        <p>(3) <em>TRAV, TRAJ, TRA_CDR3</em> and <em>TRBV, TRBJ, TRB_CDR3</em>: The information of TCRα and TCRβ chain. <em>TRAV, TRBV</em> – The V gene segment ID of TCRα and TCRβ, respectively. <em>TRAJ, TRBJ</em> – The J gene segment ID of TCRα and TCRβ, respectively. Each segment ID is with strictly IMGT nomenclature. <em>TRA_CDR3, TRB_CDR3</em> – The CDR3 amino acid sequence of TCRα and TCRβ, respectively. The complete CDR3 sequence is starting with the conserved cysteine (C) at the 5’ end of the V segment and ends with the conserved phenylalanine (F) or Tryptophane (W) at the 3’ end of the J segment. Trimmed or excessive sequences will be fixed at the data processing stage in case sufficient V/J germline parts are present.</p>
        <p>(4) <em>Cell Type</em>: This field describes the lymphocyte subtype of the TCR, e.g. CD4, and CD8.</p>
        <p>(5) <em>HLA Allele</em>: The HLA restriction of the TCR-associated neoepitope, as described in the original article.</p>
        <p>(6) <em>Source</em>: This field describes the tissues that the TCR sequence found, e.g. Healthy donor (peripheral lymphocytes of the healthy donor), TIL (tumor-infiltrating lymphocytes), Patient (peripheral lymphocytes of the cancer patient), and humanized mouse models of tumors.</p>
        <p>(7) <em>PubMed ID</em>: The PubMed Identifier (PMID) of the study&#39;s entry in the PubMed Biomedical Literature Citation Database (<a href='https://pubmed.ncbi.nlm.nih.gov/' target='_blank' class='url'>https://pubmed.ncbi.nlm.nih.gov/</a>). A link is provided for easy access to the paper.</p>
        <el-collapse accordion>
        <el-collapse-item>
            <template slot="title">
            <p>Data Source:</p><i class="header-icon el-icon-info"></i>
            </template>
            <div>
                <p>1. Matsuda T, Leisegang M, Park JH, Ren L, Kato T, Ikeda Y, Harada M, Kiyotani K, Lengyel E, Fleming GF, Nakamura Y. Induction of Neoantigen-Specific Cytotoxic T Cells and Construction of T-cell Receptor-Engineered T Cells for Ovarian Cancer. Clin Cancer Res. 2018 Nov 1;24(21):5357-5367. doi: 10.1158/1078-0432.CCR-18-0142. Epub 2018 May 2. PMID: 29720506.</p>
                <p>2. Lu YC, Zheng Z, Robbins PF, Tran E, Prickett TD, Gartner JJ, Li YF, Ray S, Franco Z, Bliskovsky V, Fitzgerald PC, Rosenberg SA. An Efficient Single-Cell RNA-Seq Approach to Identify Neoantigen-Specific T Cell Receptors. Mol Ther. 2018 Feb 7;26(2):379-389. doi: 10.1016/j.ymthe.2017.10.018. Epub 2017 Oct 28. PMID: 29174843; PMCID: PMC5835023.</p>
                <p>3. Lu YC, Zheng Z, Lowery FJ, Gartner JJ, Prickett TD, Robbins PF, Rosenberg SA. Direct identification of neoantigen-specific TCRs from tumor specimens by high-throughput single-cell sequencing. J Immunother Cancer. 2021 Jul;9(7):e002595. doi: 10.1136/jitc-2021-002595. PMID: 34321276; PMCID: PMC8320258.</p>
                <p>4. Veatch JR, Jesernig BL, Kargl J, Fitzgibbon M, Lee SM, Baik C, Martins R, Houghton AM, Riddell SR. Endogenous CD4+ T Cells Recognize Neoantigens in Lung Cancer Patients, Including Recurrent Oncogenic KRASand ERBB2 (Her2) Driver Mutations. Cancer Immunol Res. 2019 Jun;7(6):910-922. doi: 10.1158/2326-6066.CIR-18-0402. Epub 2019 May 1. PMID: 31043415; PMCID: PMC6584616.</p>
                <p>5. Çınar Ö, Brzezicha B, Grunert C, Kloetzel PM, Beier C, Peuker CA, Keller U, Pezzutto A, Busse A. High-affinity T-cell receptor specific for MyD88 L265P mutation for adoptive T-cell therapy of B-cell malignancies. J Immunother Cancer. 2021 Jul;9(7):e002410. doi: 10.1136/jitc-2021-002410. PMID: 34330762; PMCID: PMC8327818.</p>
                <p>6. Kato T, Matsuda T, Ikeda Y, Park JH, Leisegang M, Yoshimura S, Hikichi T, Harada M, Zewde M, Sato S, Hasegawa K, Kiyotani K, Nakamura Y. Effective screening of T cells recognizing neoantigens and construction of T-cell receptor-engineered T cells. Oncotarget. 2018 Jan 13;9(13):11009-11019. doi: 10.18632/oncotarget.24232. PMID: 29541393; PMCID: PMC5834292.</p>
                <p>7. Tran E, Ahmadzadeh M, Lu YC, Gros A, Turcotte S, Robbins PF, Gartner JJ, Zheng Z, Li YF, Ray S, Wunderlich JR, Somerville RP, Rosenberg SA. Immunogenicity of somatic mutations in human gastrointestinal cancers. Science. 2015 Dec 11;350(6266):1387-90. doi: 10.1126/science.aad1253. Epub 2015 Oct 29. PMID: 26516200; PMCID: PMC7445892.</p>
                <p>8. Parkhurst M, Gros A, Pasetto A, Prickett T, Crystal JS, Robbins P, Rosenberg SA. Isolation of T-Cell Receptors Specifically Reactive with Mutated Tumor-Associated Antigens from Tumor-Infiltrating Lymphocytes Based on CD137 Expression. Clin Cancer Res. 2017 May 15;23(10):2491-2505. doi: 10.1158/1078-0432.CCR-16-2680. Epub 2016 Nov 8. PMID: 27827318; PMCID: PMC6453117.</p>
                <p>9. Gros A, Tran E, Parkhurst MR, Ilyas S, Pasetto A, Groh EM, Robbins PF, Yossef R, Garcia-Garijo A, Fajardo CA, Prickett TD, Jia L, Gartner JJ, Ray S, Ngo L, Wunderllich JR, Yang JC, Rosenberg SA. Recognition of human gastrointestinal cancer neoantigens by circulating PD-1+ lymphocytes. J Clin Invest. 2019 Nov 1;129(11):4992-5004. doi: 10.1172/JCI127967. PMID: 31609250; PMCID: PMC6819109.</p>
                <p>10. Tran E, Robbins PF, Lu YC, Prickett TD, Gartner JJ, Jia L, Pasetto A, Zheng Z, Ray S, Groh EM, Kriley IR, Rosenberg SA. T-Cell Transfer Therapy Targeting Mutant KRAS in Cancer. N Engl J Med. 2016 Dec 8;375(23):2255-2262. doi: 10.1056/NEJMoa1609279. PMID: 27959684; PMCID: PMC5178827.</p>
                <p>11. Strønen E, Toebes M, Kelderman S, van Buuren MM, Yang W, van Rooij N, Donia M, Böschen ML, Lund-Johansen F, Olweus J, Schumacher TN. Targeting of cancer neoantigens with donor-derived T cell receptor repertoires. Science. 2016 Jun 10;352(6291):1337-41. doi: 10.1126/science.aaf2288. Epub 2016 May 19. PMID: 27198675.</p>
                <p>12. Caushi JX, Zhang J, Ji Z, Vaghasia A, Zhang B, Hsiue EH, Mog BJ, Hou W, Justesen S, Blosser R, Tam A, Anagnostou V, Cottrell TR, Guo H, Chan HY, Singh D, Thapa S, Dykema AG, Burman P, Choudhury B, Aparicio L, Cheung LS, Lanis M, Belcaid Z, El Asmar M, Illei PB, Wang R, Meyers J, Schuebel K, Gupta A, Skaist A, Wheelan S, Naidoo J, Marrone KA, Brock M, Ha J, Bush EL, Park BJ, Bott M, Jones DR, Reuss JE, Velculescu VE, Chaft JE, Kinzler KW, Zhou S, Vogelstein B, Taube JM, Hellmann MD, Brahmer JR, Merghoub T, Forde PM, Yegnasubramanian S, Ji H, Pardoll DM, Smith KN. Transcriptional programs of neoantigen-specific TIL in anti-PD-1-treated lung cancers. Nature. 2021 Aug;596(7870):126-132. doi: 10.1038/s41586-021-03752-4. Epub 2021 Jul 21. Erratum in: Nature. 2021 Oct;598(7881):E1. PMID: 34290408; PMCID: PMC8338555.</p>
                <p>13. Gros A, Parkhurst MR, Tran E, Pasetto A, Robbins PF, Ilyas S, Prickett TD, Gartner JJ, Crystal JS, Roberts IM, Trebska-McGowan K, Wunderlich JR, Yang JC, Rosenberg SA. Prospective identification of neoantigen-specific lymphocytes in the peripheral blood of melanoma patients. Nat Med. 2016 Apr;22(4):433-8. doi: 10.1038/nm.4051. Epub 2016 Feb 22. PMID: 26901407; PMCID: PMC7446107.</p>
                <p>14. Bräunlein E, Lupoli G, Füchsl F, Abualrous ET, de Andrade Krätzig N, Gosmann D, Wietbrock L, Lange S, Engleitner T, Lan H, Audehm S, Effenberger M, Boxberg M, Steiger K, Chang Y, Yu K, Atay C, Bassermann F, Weichert W, Busch DH, Rad R, Freund C, Antes I, Krackhardt AM. Functional analysis of peripheral and intratumoral neoantigen-specific TCRs identified in a patient with melanoma. J Immunother Cancer. 2021 Sep;9(9):e002754. doi: 10.1136/jitc-2021-002754. PMID: 34518289; PMCID: PMC8438848.</p>
                <p>15. Lowery FJ, Krishna S, Yossef R, Parikh NB, Chatani PD, Zacharakis N, Parkhurst MR, Levin N, Sindiri S, Sachs A, Hitscherich KJ, Yu Z, Vale NR, Lu YC, Zheng Z, Jia L, Gartner JJ, Hill VK, Copeland AR, Nah SK, Masi RV, Gasmi B, Kivitz S, Paria BC, Florentin M, Kim SP, Hanada KI, Li YF, Ngo LT, Ray S, Shindorf ML, Levi ST, Shepherd R, Toy C, Parikh AY, Prickett TD, Kelly MC, Beyer R, Goff SL, Yang JC, Robbins PF, Rosenberg SA. Molecular signatures of antitumor neoantigen-reactive T cells from metastatic human cancers. Science. 2022 Feb 25;375(6583):877-884. doi: 10.1126/science.abl5447. Epub 2022 Feb 3. PMID: 35113651; PMCID: PMC8996692.</p>
                <p>16. Sim MJW, Lu J, Spencer M, Hopkins F, Tran E, Rosenberg SA, Long EO, Sun PD. High-affinity oligoclonal TCRs define effective adoptive T cell therapy targeting mutant KRAS-G12D. Proc Natl Acad Sci U S A. 2020 Jun 9;117(23):12826-12835. doi: 10.1073/pnas.1921964117. Epub 2020 May 27. Erratum in: Proc Natl Acad Sci U S A. 2020 Nov 3;117(44):27743-27744. PMID: 32461371; PMCID: PMC7293613.</p>
                <p>17. Levin N, Paria BC, Vale NR, Yossef R, Lowery FJ, Parkhurst MR, Yu Z, Florentin M, Cafri G, Gartner JJ, Shindorf ML, Ngo LT, Ray S, Kim SP, Copeland AR, Robbins PF, Rosenberg SA. Identification and Validation of T-cell Receptors Targeting RAS Hotspot Mutations in Human Cancers for Use in Cell-based Immunotherapy. Clin Cancer Res. 2021 Sep 15;27(18):5084-5095. doi: 10.1158/1078-0432.CCR-21-0849. Epub 2021 Jun 24. PMID: 34168045; PMCID: PMC8448939.</p>
                <p>18. Cafri G, Gartner JJ, Zaks T, Hopson K, Levin N, Paria BC, Parkhurst MR, Yossef R, Lowery FJ, Jafferji MS, Prickett TD, Goff SL, McGowan CT, Seitter S, Shindorf ML, Parikh A, Chatani PD, Robbins PF, Rosenberg SA. mRNA vaccine-induced neoantigen-specific T cell immunity in patients with gastrointestinal cancer. J Clin Invest. 2020 Nov 2;130(11):5976-5988. doi: 10.1172/JCI134915. PMID: 33016924; PMCID: PMC7598064.</p>
                <p>19. Levin N, Paria BC, Vale NR, Yossef R, Lowery FJ, Parkhurst MR, Yu Z, Florentin M, Cafri G, Gartner JJ, Shindorf ML, Ngo LT, Ray S, Kim SP, Copeland AR, Robbins PF, Rosenberg SA. Identification and Validation of T-cell Receptors Targeting RAS Hotspot Mutations in Human Cancers for Use in Cell-based Immunotherapy. Clin Cancer Res. 2021 Sep 15;27(18):5084-5095. doi: 10.1158/1078-0432.CCR-21-0849. Epub 2021 Jun 24. PMID: 34168045; PMCID: PMC8448939.</p>
                <p>20. Cafri G, Yossef R, Pasetto A, Deniger DC, Lu YC, Parkhurst M, Gartner JJ, Jia L, Ray S, Ngo LT, Jafferji M, Sachs A, Prickett T, Robbins PF, Rosenberg SA. Memory T cells targeting oncogenic mutations detected in peripheral blood of epithelial cancer patients. Nat Commun. 2019 Jan 25;10(1):449. doi: 10.1038/s41467-019-08304-z. PMID: 30683863; PMCID: PMC6347629.</p>
                <p>21. Yossef R, Tran E, Deniger DC, Gros A, Pasetto A, Parkhurst MR, Gartner JJ, Prickett TD, Cafri G, Robbins PF, Rosenberg SA. Enhanced detection of neoantigen-reactive T cells targeting unique and shared oncogenes for personalized cancer immunotherapy. JCI Insight. 2018 Oct 4;3(19):e122467. doi: 10.1172/jci.insight.122467. PMID: 30282837; PMCID: PMC6237474.</p>
                <p>22. Tran E, Turcotte S, Gros A, Robbins PF, Lu YC, Dudley ME, Wunderlich JR, Somerville RP, Hogan K, Hinrichs CS, Parkhurst MR, Yang JC, Rosenberg SA. Cancer immunotherapy based on mutation-specific CD4+ T cells in a patient with epithelial cancer. Science. 2014 May 9;344(6184):641-5. doi: 10.1126/science.1251102. PMID: 24812403; PMCID: PMC6686185.</p>
                <p>23. Yossef R, Tran E, Deniger DC, Gros A, Pasetto A, Parkhurst MR, Gartner JJ, Prickett TD, Cafri G, Robbins PF, Rosenberg SA. Enhanced detection of neoantigen-reactive T cells targeting unique and shared oncogenes for personalized cancer immunotherapy. JCI Insight. 2018 Oct 4;3(19):e122467. doi: 10.1172/jci.insight.122467. PMID: 30282837; PMCID: PMC6237474.</p>
                <p>24. Zacharakis N, Chinnasamy H, Black M, Xu H, Lu YC, Zheng Z, Pasetto A, Langhan M, Shelton T, Prickett T, Gartner J, Jia L, Trebska-McGowan K, Somerville RP, Robbins PF, Rosenberg SA, Goff SL, Feldman SA. Immune recognition of somatic mutations leading to complete durable regression in metastatic breast cancer. Nat Med. 2018 Jun;24(6):724-730. doi: 10.1038/s41591-018-0040-8. Epub 2018 Jun 4. PMID: 29867227; PMCID: PMC6348479.</p>
                <p>25. Parkhurst MR, Robbins PF, Tran E, Prickett TD, Gartner JJ, Jia L, Ivey G, Li YF, El-Gamil M, Lalani A, Crystal JS, Sachs A, Groh E, Ray S, Ngo LT, Kivitz S, Pasetto A, Yossef R, Lowery FJ, Goff SL, Lo W, Cafri G, Deniger DC, Malekzadeh P, Ahmadzadeh M, Wunderlich JR, Somerville RPT, Rosenberg SA. Unique Neoantigens Arise from Somatic Mutations in Patients with Gastrointestinal Cancers. Cancer Discov. 2019 Aug;9(8):1022-1035. doi: 10.1158/2159-8290.CD-18-1494. Epub 2019 Jun 4. PMID: 31164343; PMCID: PMC7138461.</p>
                <p>26. Malekzadeh P, Pasetto A, Robbins PF, Parkhurst MR, Paria BC, Jia L, Gartner JJ, Hill V, Yu Z, Restifo NP, Sachs A, Tran E, Lo W, Somerville RP, Rosenberg SA, Deniger DC. Neoantigen screening identifies broad TP53 mutant immunogenicity in patients with epithelial cancers. J Clin Invest. 2019 Mar 1;129(3):1109-1114. doi: 10.1172/JCI123791. Epub 2019 Feb 4. PMID: 30714987; PMCID: PMC6391139.</p>
                <p>27. Prickett TD, Crystal JS, Cohen CJ, Pasetto A, Parkhurst MR, Gartner JJ, Yao X, Wang R, Gros A, Li YF, El-Gamil M, Trebska-McGowan K, Rosenberg SA, Robbins PF. Durable Complete Response from Metastatic Melanoma after Transfer of Autologous T Cells Recognizing 10 Mutated Tumor Antigens. Cancer Immunol Res. 2016 Aug;4(8):669-78. doi: 10.1158/2326-6066.CIR-15-0215. Epub 2016 Jun 16. PMID: 27312342; PMCID: PMC4970903.</p>
                <p>28. Krishna S, Lowery FJ, Copeland AR, Bahadiroglu E, Mukherjee R, Jia L, Anibal JT, Sachs A, Adebola SO, Gurusamy D, Yu Z, Hill V, Gartner JJ, Li YF, Parkhurst M, Paria B, Kvistborg P, Kelly MC, Goff SL, Altan-Bonnet G, Robbins PF, Rosenberg SA. Stem-like CD8 T cells mediate response of adoptive cell immunotherapy against human cancer. Science. 2020 Dec 11;370(6522):1328-1334. doi: 10.1126/science.abb9847. PMID: 33303615; PMCID: PMC8883579.</p>
                <p>29. Levin N, Paria BC, Vale NR, Yossef R, Lowery FJ, Parkhurst MR, Yu Z, Florentin M, Cafri G, Gartner JJ, Shindorf ML, Ngo LT, Ray S, Kim SP, Copeland AR, Robbins PF, Rosenberg SA. Identification and Validation of T-cell Receptors Targeting RAS Hotspot Mutations in Human Cancers for Use in Cell-based Immunotherapy. Clin Cancer Res. 2021 Sep 15;27(18):5084-5095. doi: 10.1158/1078-0432.CCR-21-0849. Epub 2021 Jun 24. PMID: 34168045; PMCID: PMC8448939.</p>
                <p>30. Turcotte S, Gros A, Tran E, Lee CC, Wunderlich JR, Robbins PF, Rosenberg SA. Tumor-reactive CD8+ T cells in metastatic gastrointestinal cancer refractory to chemotherapy. Clin Cancer Res. 2014 Jan 15;20(2):331-43. doi: 10.1158/1078-0432.CCR-13-1736. Epub 2013 Nov 11. PMID: 24218514; PMCID: PMC3927404.</p>
                <p>31. Lo W, Parkhurst M, Robbins PF, Tran E, Lu YC, Jia L, Gartner JJ, Pasetto A, Deniger D, Malekzadeh P, Shelton TE, Prickett T, Ray S, Kivitz S, Paria BC, Kriley I, Schrump DS, Rosenberg SA. Immunologic Recognition of a Shared p53 Mutated Neoantigen in a Patient with Metastatic Colorectal Cancer. Cancer Immunol Res. 2019 Apr;7(4):534-543. doi: 10.1158/2326-6066.CIR-18-0686. Epub 2019 Feb 1. PMID: 30709841; PMCID: PMC6685528.</p>
                <p>32. Leko V, McDuffie LA, Zheng Z, Gartner JJ, Prickett TD, Apolo AB, Agarwal PK, Rosenberg SA, Lu YC. Identification of Neoantigen-Reactive Tumor-Infiltrating Lymphocytes in Primary Bladder Cancer. J Immunol. 2019 Jun 15;202(12):3458-3467. doi: 10.4049/jimmunol.1801022. Epub 2019 Apr 29. PMID: 31036766; PMCID: PMC6548619.</p>
                <p>33. Cafri G, Yossef R, Pasetto A, Deniger DC, Lu YC, Parkhurst M, Gartner JJ, Jia L, Ray S, Ngo LT, Jafferji M, Sachs A, Prickett T, Robbins PF, Rosenberg SA. Memory T cells targeting oncogenic mutations detected in peripheral blood of epithelial cancer patients. Nat Commun. 2019 Jan 25;10(1):449. doi: 10.1038/s41467-019-08304-z. PMID: 30683863; PMCID: PMC6347629.</p>
                <p>34. Peri A, Greenstein E, Alon M, Pai JA, Dingjan T, Reich-Zeliger S, Barnea E, Barbolin C, Levy R, Arnedo-Pac C, Kalaora S, Dassa B, Feldmesser E, Shang P, Greenberg P, Levin Y, Benedek G, Levesque MP, Adams DJ, Lotem M, Wilmott JS, Scolyer RA, Jönsson GB, Admon A, Rosenberg SA, Cohen CJ, Niv MY, Lopez-Bigas N, Satpathy AT, Friedman N, Samuels Y. Combined presentation and immunogenicity analysis reveals a recurrent RAS.Q61K neoantigen in melanoma. J Clin Invest. 2021 Oct 15;131(20):e129466. doi: 10.1172/JCI129466. PMID: 34651586; PMCID: PMC8516471.</p>
                <p>35. Anagnostou V, Smith KN, Forde PM, Niknafs N, Bhattacharya R, White J, Zhang T, Adleff V, Phallen J, Wali N, Hruban C, Guthrie VB, Rodgers K, Naidoo J, Kang H, Sharfman W, Georgiades C, Verde F, Illei P, Li QK, Gabrielson E, Brock MV, Zahnow CA, Baylin SB, Scharpf RB, Brahmer JR, Karchin R, Pardoll DM, Velculescu VE. Evolution of Neoantigen Landscape during Immune Checkpoint Blockade in Non-Small Cell Lung Cancer. Cancer Discov. 2017 Mar;7(3):264-276. doi: 10.1158/2159-8290.CD-16-0828. Epub 2016 Dec 28. PMID: 28031159; PMCID: PMC5733805.</p>
                <p>36. Hirama T, Tokita S, Nakatsugawa M, Murata K, Nannya Y, Matsuo K, Inoko H, Hirohashi Y, Hashimoto S, Ogawa S, Takemasa I, Sato N, Hata F, Kanaseki T, Torigoe T. Proteogenomic identification of an immunogenic HLA class I neoantigen in mismatch repair-deficient colorectal cancer tissue. JCI Insight. 2021 Jul 22;6(14):e146356. doi: 10.1172/jci.insight.146356. PMID: 34185709; PMCID: PMC8410045.</p>
                <p>37. Creelan BC, Wang C, Teer JK, Toloza EM, Yao J, Kim S, Landin AM, Mullinax JE, Saller JJ, Saltos AN, Noyes DR, Montoya LB, Curry W, Pilon-Thomas SA, Chiappori AA, Tanvetyanon T, Kaye FJ, Thompson ZJ, Yoder SJ, Fang B, Koomen JM, Sarnaik AA, Chen DT, Conejo-Garcia JR, Haura EB, Antonia SJ. Tumor-infiltrating lymphocyte treatment for anti-PD-1-resistant metastatic lung cancer: a phase 1 trial. Nat Med. 2021 Aug;27(8):1410-1418. doi: 10.1038/s41591-021-01462-y. Epub 2021 Aug 12. PMID: 34385708; PMCID: PMC8509078.</p>
                <p>38. Wei T, Leisegang M, Xia M, Kiyotani K, Li N, Zeng C, Deng C, Jiang J, Harada M, Agrawal N, Li L, Qi H, Nakamura Y, Ren L. Generation of neoantigen-specific T cells for adoptive cell transfer for treating head and neck squamous cell carcinoma. Oncoimmunology. 2021 May 25;10(1):1929726. doi: 10.1080/2162402X.2021.1929726. PMID: 34104546; PMCID: PMC8158031.</p>
                <p>39. Zheng C, Fass JN, Shih YP, Gunderson AJ, Sanjuan Silva N, Huang H, Bernard BM, Rajamanickam V, Slagel J, Bifulco CB, Piening B, Newell PHA, Hansen PD, Tran E. Transcriptomic profiles of neoantigen-reactive T cells in human gastrointestinal cancers. Cancer Cell. 2022 Apr 11;40(4):410-423.e7. doi: 10.1016/j.ccell.2022.03.005. PMID: 35413272.</p>
                <p>40. McCann K, von Witzleben A, Thomas J, Wang C, Wood O, Singh D, Boukas K, Bendjama K, Silvestre N, Nielsen FC, Thomas G, Sanchez-Elsner T, Greenbaum J, Schoenberger S, Peters B, Vijayanand P, Savelyeva N, Ottensmeier C. Targeting the tumor mutanome for personalized vaccination in a TMB low non-small cell lung cancer. J Immunother Cancer. 2022 Mar;10(3):e003821. doi: 10.1136/jitc-2021-003821. PMID: 35361728; PMCID: PMC8971766.</p>
                <p>41. Wang QJ, Yu Z, Griffith K, Hanada K, Restifo NP, Yang JC. Identification of T-cell Receptors Targeting KRAS-Mutated Human Tumors. Cancer Immunol Res. 2016 Mar;4(3):204-14. doi: 10.1158/2326-6066.CIR-15-0188. Epub 2015 Dec 23. PMID: 26701267; PMCID: PMC4775432.</p>
                <p>42. Hu Z, Anandappa AJ, Sun J, Kim J, Leet DE, Bozym DJ, Chen C, Williams L, Shukla SA, Zhang W, Tabbaa D, Steelman S, Olive O, Livak KJ, Kishi H, Muraguchi A, Guleria I, Stevens J, Lane WJ, Burkhardt UE, Fritsch EF, Neuberg D, Ott PA, Keskin DB, Hacohen N, Wu CJ. A cloning and expression system to probe T-cell receptor specificity and assess functional avidity to neoantigens. Blood. 2018 Nov 1;132(18):1911-1921. doi: 10.1182/blood-2018-04-843763. Epub 2018 Aug 27. PMID: 30150207; PMCID: PMC6213317.</p>
                <p>43. Veatch JR, Lee SM, Fitzgibbon M, Chow IT, Jesernig B, Schmitt T, Kong YY, Kargl J, Houghton AM, Thompson JA, McIntosh M, Kwok WW, Riddell SR. Tumor-infiltrating BRAFV600E-specific CD4+ T cells correlated with complete clinical response in melanoma. J Clin Invest. 2018 Apr 2;128(4):1563-1568. doi: 10.1172/JCI98689. Epub 2018 Mar 12. PMID: 29360643; PMCID: PMC5873881.</p>
                <p>44. Kerr CM, Clemente MJ, Chomczynski PW, Przychodzen B, Nagata Y, Adema V, Visconte V, Lichtin AE, Mustjoki S, Radivoyevitch T, Sekeres MA, Maciejewski JP. Subclonal STAT3 mutations solidify clonal dominance. Blood Adv. 2019 Mar 26;3(6):917-921. doi: 10.1182/bloodadvances.2018027862. PMID: 30898763; PMCID: PMC6436009.</p>
                <p>45. Dillard P, Casey N, Pollmann S, Vernhoff P, Gaudernack G, Kvalheim G, Wälchli S, Inderberg EM. Targeting KRAS mutations with HLA class II-restricted TCRs for the treatment of solid tumors. Oncoimmunology. 2021 Jun 17;10(1):1936757. doi: 10.1080/2162402X.2021.1936757. PMID: 34235003; PMCID: PMC8216182.</p>
                <p>46. Bhattacharya D, Teramo A, Gasparini VR, Huuhtanen J, Kim D, Theodoropoulos J, Schiavoni G, Barilà G, Vicenzetto C, Calabretto G, Facco M, Kawakami T, Nakazawa H, Falini B, Tiacci E, Ishida F, Semenzato G, Kelkka T, Zambello R, Mustjoki S. Identification of novel STAT5B mutations and characterization of TCRβ signatures in CD4+ T-cell large granular lymphocyte leukemia. Blood Cancer J. 2022 Feb 24;12(2):31. doi: 10.1038/s41408-022-00630-8. PMID: 35210405; PMCID: PMC8873566.</p>
                <p>47. Gros A, Robbins PF, Yao X, Li YF, Turcotte S, Tran E, Wunderlich JR, Mixon A, Farid S, Dudley ME, Hanada K, Almeida JR, Darko S, Douek DC, Yang JC, Rosenberg SA. PD-1 identifies the patient-specific CD8⁺ tumor-reactive repertoire infiltrating human tumors. J Clin Invest. 2014 May;124(5):2246-59. doi: 10.1172/JCI73639. Epub 2014 Mar 25. PMID: 24667641; PMCID: PMC4001555.</p>
                <p>48. Bigot J, Lalanne AI, Lucibello F, Gueguen P, Houy A, Dayot S, Ganier O, Gilet J, Tosello J, Nemati F, Pierron G, Waterfall JJ, Barnhill R, Gardrat S, Piperno-Neumann S, Popova T, Masson V, Loew D, Mariani P, Cassoux N, Amigorena S, Rodrigues M, Alsafadi S, Stern MH, Lantz O. Splicing Patterns in SF3B1-Mutated Uveal Melanoma Generate Shared Immunogenic Tumor-Specific Neoepitopes. Cancer Discov. 2021 Aug;11(8):1938-1951. doi: 10.1158/2159-8290.CD-20-0555. Epub 2021 Apr 2. Erratum in: Cancer Discov. 2022 Mar 1;12(3):872. PMID: 33811047.</p>
                <p>49. Grunert C, Willimsky G, Peuker CA, Rhein S, Hansmann L, Blankenstein T, Blanc E, Beule D, Keller U, Pezzutto A, Busse A. Isolation of Neoantigen-Specific Human T Cell Receptors from Different Human and Murine Repertoires. Cancers (Basel). 2022 Apr 6;14(7):1842. doi: 10.3390/cancers14071842. PMID: 35406613; PMCID: PMC8998067.</p>
                <p>50. Biernacki MA, Foster KA, Woodward KB, Coon ME, Cummings C, Cunningham TM, Dossa RG, Brault M, Stokke J, Olsen TM, Gardner K, Estey E, Meshinchi S, Rongvaux A, Bleakley M. CBFB-MYH11 fusion neoantigen enables T cell recognition and killing of acute myeloid leukemia. J Clin Invest. 2020 Oct 1;130(10):5127-5141. doi: 10.1172/JCI137723. PMID: 32831296; PMCID: PMC7524498.</p>
                <p>51. Carreno BM, Magrini V, Becker-Hapak M, Kaabinejadian S, Hundal J, Petti AA, Ly A, Lie WR, Hildebrand WH, Mardis ER, Linette GP. Cancer immunotherapy. A dendritic cell vaccine increases the breadth and diversity of melanoma neoantigen-specific T cells. Science. 2015 May 15;348(6236):803-8. doi: 10.1126/science.aaa3828. Epub 2015 Apr 2. PMID: 25837513; PMCID: PMC4549796.</p>
                <p>52. Linette GP, Becker-Hapak M, Skidmore ZL, Baroja ML, Xu C, Hundal J, Spencer DH, Fu W, Cummins C, Robnett M, Kaabinejadian S, Hildebrand WH, Magrini V, Demeter R, Krupnick AS, Griffith OL, Griffith M, Mardis ER, Carreno BM. Immunological ignorance is an enabling feature of the oligo-clonal T cell response to melanoma neoantigens. Proc Natl Acad Sci U S A. 2019 Nov 19;116(47):23662-23670. doi: 10.1073/pnas.1906026116. Epub 2019 Nov 4. PMID: 31685621; PMCID: PMC6876217.</p>
                <p>53. Ueda N, Zhang R, Tatsumi M, Liu TY, Kitayama S, Yasui Y, Sugai S, Iwama T, Senju S, Okada S, Nakatsura T, Kuzushima K, Kiyoi H, Naoe T, Kaneko S, Uemura Y. BCR-ABL-specific CD4+T-helper cells promote the priming of antigen-specific cytotoxic T cells via dendritic cells. Cell Mol Immunol. 2018 Jan;15(1):15-26. doi: 10.1038/cmi.2016.7. Epub 2016 May 15. PMID: 27181332; PMCID: PMC5827172.</p>
                <p>54. Linette GP, Becker-Hapak M, Skidmore ZL, Baroja ML, Xu C, Hundal J, Spencer DH, Fu W, Cummins C, Robnett M, Kaabinejadian S, Hildebrand WH, Magrini V, Demeter R, Krupnick AS, Griffith OL, Griffith M, Mardis ER, Carreno BM. Immunological ignorance is an enabling feature of the oligo-clonal T cell response to melanoma neoantigens. Proc Natl Acad Sci U S A. 2019 Nov 19;116(47):23662-23670. doi: 10.1073/pnas.1906026116. Epub 2019 Nov 4. PMID: 31685621; PMCID: PMC6876217.</p>
                <p>55. Zamora AE, Crawford JC, Allen EK, Guo XJ, Bakke J, Carter RA, Abdelsamed HA, Moustaki A, Li Y, Chang TC, Awad W, Dallas MH, Mullighan CG, Downing JR, Geiger TL, Chen T, Green DR, Youngblood BA, Zhang J, Thomas PG. Pediatric patients with acute lymphoblastic leukemia generate abundant and functional neoantigen-specific CD8+ T cell responses. Sci Transl Med. 2019 Jun 26;11(498):eaat8549. doi: 10.1126/scitranslmed.aat8549. PMID: 31243155; PMCID: PMC7020562.</p>
                <p>56. Arnaud M, Chiffelle J, Genolet R, Navarro Rodrigo B, Perez MAS, Huber F, Magnin M, Nguyen-Ngoc T, Guillaume P, Baumgaertner P, Chong C, Stevenson BJ, Gfeller D, Irving M, Speiser DE, Schmidt J, Zoete V, Kandalaft LE, Bassani-Sternberg M, Bobisse S, Coukos G, Harari A. Sensitive identification of neoantigens and cognate TCRs in human solid tumors. Nat Biotechnol. 2022 May;40(5):656-660. doi: 10.1038/s41587-021-01072-6. Epub 2021 Nov 15. PMID: 34782741; PMCID: PMC9110298.</p>
            </div>
        </el-collapse-item>
</el-collapse>
        <h4 id='2searching-example'>2.Searching example:</h4>
        <p><img src="../../../../assets/css/image/browse-search-w.png" alt="image-20220629161514843" style="zoom:90%;" /></p>
        <p><img src="../../../../assets/css/image/browse-result-w.png" alt="image-20220629161555856" style="zoom:90%;" /></p>
      </el-card>
</div>
</template>

<script>
export default {
    name:"browse",
    
}

</script>
<style scoped>
/* .help_image{
    width: 100px !important;
    margin: 0 auto; text-align: center
} */
.box-card{
    margin: 2%;
}
.mac-os-11 { --title-bar-height:28px; }
html { font-size: 14px; background-color: var(--bg-color); color: var(--text-color); font-family: "Helvetica Neue", Helvetica, Arial, sans-serif; -webkit-font-smoothing: antialiased; }
body { margin: 0px; padding: 0px; height: auto; inset: 0px; font-size: 1rem; line-height: 1.42857; overflow-x: hidden; background: inherit; tab-size: 4; }
iframe { margin: auto; }
a.url { word-break: break-all; }
a:active, a:hover { outline: 0px; }
.in-text-selection, ::selection { text-shadow: none; background: var(--select-text-bg-color); color: var(--select-text-font-color); }
#write { margin: 0px auto; height: auto; width: inherit; word-break: normal; overflow-wrap: break-word; position: relative; white-space: normal; overflow-x: visible; padding-top: 36px; }
#write.first-line-indent p { text-indent: 2em; }
#write.first-line-indent li p, #write.first-line-indent p * { text-indent: 0px; }
#write.first-line-indent li { margin-left: 2em; }
.for-image #write { padding-left: 8px; padding-right: 8px; }
body.typora-export { padding-left: 30px; padding-right: 30px; }
.typora-export .footnote-line, .typora-export li, .typora-export p { white-space: pre-wrap; }
.typora-export .task-list-item input { pointer-events: none; }
@media screen and (max-width: 500px) {
  body.typora-export { padding-left: 0px; padding-right: 0px; }
  #write { padding-left: 20px; padding-right: 20px; }
  .CodeMirror-sizer { margin-left: 0px !important; }
  .CodeMirror-gutters { display: none !important; }
}
#write li > figure:last-child { margin-bottom: 0.5rem; }
#write ol, #write ul { position: relative; }
img { max-width: 100%; vertical-align: middle; image-orientation: from-image; }
button, input, select, textarea { color: inherit; font: inherit; }
input[type="checkbox"], input[type="radio"] { line-height: normal; padding: 0px; }
*, ::after, ::before { box-sizing: border-box; }
#write h1, #write h2, #write h3, #write h4, #write h5, #write h6, #write p, #write pre { width: inherit; }
#write h1, #write h2, #write h3, #write h4, #write h5, #write h6, #write p { position: relative; }
p { line-height: inherit; }
h1, h2, h3, h4, h5, h6 { break-after: avoid-page; break-inside: avoid; orphans: 4; }
p { orphans: 4; }
h1 { font-size: 2rem; }
h2 { font-size: 1.8rem; }
h3 { font-size: 1.6rem; }
h4 { font-size: 1.4rem; }
h5 { font-size: 1.2rem; }
h6 { font-size: 1rem; }
.md-math-block, .md-rawblock, h1, h2, h3, h4, h5, h6, p { margin-top: 1rem; margin-bottom: 1rem; }
.hidden { display: none; }
.md-blockmeta { color: rgb(204, 204, 204); font-weight: 700; font-style: italic; }
a { cursor: pointer; }
sup.md-footnote { padding: 2px 4px; background-color: rgba(238, 238, 238, 0.7); color: rgb(85, 85, 85); border-radius: 4px; cursor: pointer; }
sup.md-footnote a, sup.md-footnote a:hover { color: inherit; text-transform: inherit; text-decoration: inherit; }
#write input[type="checkbox"] { cursor: pointer; width: inherit; height: inherit; }
figure { overflow-x: auto; margin: 1.2em 0px; max-width: calc(100% + 16px); padding: 0px; }
figure > table { margin: 0px; }
tr { break-inside: avoid; break-after: auto; }
thead { display: table-header-group; }
table { border-collapse: collapse; border-spacing: 0px; width: 100%; overflow: auto; break-inside: auto; text-align: left; }
table.md-table td { min-width: 32px; }
.CodeMirror-gutters { border-right: 0px; background-color: inherit; }
.CodeMirror-linenumber { user-select: none; }
.CodeMirror { text-align: left; }
.CodeMirror-placeholder { opacity: 0.3; }
.CodeMirror pre { padding: 0px 4px; }
.CodeMirror-lines { padding: 0px; }
div.hr:focus { cursor: none; }
#write pre { white-space: pre-wrap; }
#write.fences-no-line-wrapping pre { white-space: pre; }
#write pre.ty-contain-cm { white-space: normal; }
.CodeMirror-gutters { margin-right: 4px; }
.md-fences { font-size: 0.9rem; display: block; break-inside: avoid; text-align: left; overflow: visible; white-space: pre; background: inherit; position: relative !important; }
.md-fences-adv-panel { width: 100%; margin-top: 10px; text-align: center; padding-top: 0px; padding-bottom: 8px; overflow-x: auto; }
#write .md-fences.mock-cm { white-space: pre-wrap; }
.md-fences.md-fences-with-lineno { padding-left: 0px; }
#write.fences-no-line-wrapping .md-fences.mock-cm { white-space: pre; overflow-x: auto; }
.md-fences.mock-cm.md-fences-with-lineno { padding-left: 8px; }
.CodeMirror-line, twitterwidget { break-inside: avoid; }
.footnotes { opacity: 0.8; font-size: 0.9rem; margin-top: 1em; margin-bottom: 1em; }
.footnotes + .footnotes { margin-top: 0px; }
.md-reset { margin: 0px; padding: 0px; border: 0px; outline: 0px; vertical-align: top; background: 0px 0px; text-decoration: none; text-shadow: none; float: none; position: static; width: auto; height: auto; white-space: nowrap; cursor: inherit; -webkit-tap-highlight-color: transparent; line-height: normal; font-weight: 400; text-align: left; box-sizing: content-box; direction: ltr; }
li div { padding-top: 0px; }
blockquote { margin: 1rem 0px; }
li .mathjax-block, li p { margin: 0.5rem 0px; }
li blockquote { margin: 1rem 0px; }
li { margin: 0px; position: relative; }
blockquote > :last-child { margin-bottom: 0px; }
blockquote > :first-child, li > :first-child { margin-top: 0px; }
.footnotes-area { color: rgb(136, 136, 136); margin-top: 0.714rem; padding-bottom: 0.143rem; white-space: normal; }
#write .footnote-line { white-space: pre-wrap; }
@media print {
  body, html { border: 1px solid transparent; height: 99%; break-after: avoid; break-before: avoid; font-variant-ligatures: no-common-ligatures; }
  #write { margin-top: 0px; padding-top: 0px; border-color: transparent !important; }
  .typora-export * { -webkit-print-color-adjust: exact; }
  .typora-export #write { break-after: avoid; }
  .typora-export #write::after { height: 0px; }
  .is-mac table { break-inside: avoid; }
  .typora-export-show-outline .typora-export-sidebar { display: none; }
}
.footnote-line { margin-top: 0.714em; font-size: 0.7em; }
a img, img a { cursor: pointer; }
pre.md-meta-block { font-size: 0.8rem; min-height: 0.8rem; white-space: pre-wrap; background: rgb(204, 204, 204); display: block; overflow-x: hidden; }
p > .md-image:only-child:not(.md-img-error) img, p > img:only-child { display: block; margin: auto; }
#write.first-line-indent p > .md-image:only-child:not(.md-img-error) img { left: -2em; position: relative; }
p > .md-image:only-child { display: inline-block; width: 100%; }
#write .MathJax_Display { margin: 0.8em 0px 0px; }
.md-math-block { width: 100%; }
.md-math-block:not(:empty)::after { display: none; }
.MathJax_ref { fill: currentcolor; }
[contenteditable="true"]:active, [contenteditable="true"]:focus, [contenteditable="false"]:active, [contenteditable="false"]:focus { outline: 0px; box-shadow: none; }
.md-task-list-item { position: relative; list-style-type: none; }
.task-list-item.md-task-list-item { padding-left: 0px; }
.md-task-list-item > input { position: absolute; top: 0px; left: 0px; margin-left: -1.2em; margin-top: calc(1em - 10px); border: none; }
.math { font-size: 1rem; }
.md-toc { min-height: 3.58rem; position: relative; font-size: 0.9rem; border-radius: 10px; }
.md-toc-content { position: relative; margin-left: 0px; }
.md-toc-content::after, .md-toc::after { display: none; }
.md-toc-item { display: block; color: rgb(65, 131, 196); }
.md-toc-item a { text-decoration: none; }
.md-toc-inner:hover { text-decoration: underline; }
.md-toc-inner { display: inline-block; cursor: pointer; }
.md-toc-h1 .md-toc-inner { margin-left: 0px; font-weight: 700; }
.md-toc-h2 .md-toc-inner { margin-left: 2em; }
.md-toc-h3 .md-toc-inner { margin-left: 4em; }
.md-toc-h4 .md-toc-inner { margin-left: 6em; }
.md-toc-h5 .md-toc-inner { margin-left: 8em; }
.md-toc-h6 .md-toc-inner { margin-left: 10em; }
@media screen and (max-width: 48em) {
  .md-toc-h3 .md-toc-inner { margin-left: 3.5em; }
  .md-toc-h4 .md-toc-inner { margin-left: 5em; }
  .md-toc-h5 .md-toc-inner { margin-left: 6.5em; }
  .md-toc-h6 .md-toc-inner { margin-left: 8em; }
}
a.md-toc-inner { font-size: inherit; font-style: inherit; font-weight: inherit; line-height: inherit; }
.footnote-line a:not(.reversefootnote) { color: inherit; }
.md-attr { display: none; }
.md-fn-count::after { content: "."; }
code, pre, samp, tt { font-family: var(--monospace); }
kbd { margin: 0px 0.1em; padding: 0.1em 0.6em; font-size: 0.8em; color: rgb(36, 39, 41); background: rgb(255, 255, 255); border: 1px solid rgb(173, 179, 185); border-radius: 3px; box-shadow: rgba(12, 13, 14, 0.2) 0px 1px 0px, rgb(255, 255, 255) 0px 0px 0px 2px inset; white-space: nowrap; vertical-align: middle; }
.md-comment { color: rgb(162, 127, 3); opacity: 0.6; font-family: var(--monospace); }
code { text-align: left; vertical-align: initial; }
a.md-print-anchor { white-space: pre !important; border-width: initial !important; border-style: none !important; border-color: initial !important; display: inline-block !important; position: absolute !important; width: 1px !important; right: 0px !important; outline: 0px !important; background: 0px 0px !important; text-decoration: initial !important; text-shadow: initial !important; }
.os-windows.monocolor-emoji .md-emoji { font-family: "Segoe UI Symbol", sans-serif; }
.md-diagram-panel > svg { max-width: 100%; }
[lang="flow"] svg, [lang="mermaid"] svg { max-width: 100%; height: auto; }
[lang="mermaid"] .node text { font-size: 1rem; }
table tr th { border-bottom: 0px; }
video { max-width: 100%; display: block; margin: 0px auto; }
iframe { max-width: 100%; width: 100%; border: none; }
.highlight td, .highlight tr { border: 0px; }
mark { background: rgb(255, 255, 0); color: rgb(0, 0, 0); }
.md-html-inline .md-plain, .md-html-inline strong, mark .md-inline-math, mark strong { color: inherit; }
.md-expand mark .md-meta { opacity: 0.3 !important; }
mark .md-meta { color: rgb(0, 0, 0); }
@media print {
  .typora-export h1, .typora-export h2, .typora-export h3, .typora-export h4, .typora-export h5, .typora-export h6 { break-inside: avoid; }
}
.md-diagram-panel .messageText { stroke: none !important; }
.md-diagram-panel .start-state { fill: var(--node-fill); }
.md-diagram-panel .edgeLabel rect { opacity: 1 !important; }
.md-fences.md-fences-math { font-size: 1em; }
.md-fences-advanced:not(.md-focus) { padding: 0px; white-space: nowrap; border: 0px; }
.md-fences-advanced:not(.md-focus) { background: inherit; }
.typora-export-show-outline .typora-export-content { max-width: 1440px; margin: auto; display: flex; flex-direction: row; }
.typora-export-sidebar { width: 300px; font-size: 0.8rem; margin-top: 80px; margin-right: 18px; }
.typora-export-show-outline #write { --webkit-flex:2; flex: 2 1 0%; }
.typora-export-sidebar .outline-content { position: fixed; top: 0px; max-height: 100%; overflow: hidden auto; padding-bottom: 30px; padding-top: 60px; width: 300px; }
@media screen and (max-width: 1024px) {
  .typora-export-sidebar, .typora-export-sidebar .outline-content { width: 240px; }
}
@media screen and (max-width: 800px) {
  .typora-export-sidebar { display: none; }
}
.outline-content li, .outline-content ul { margin-left: 0px; margin-right: 0px; padding-left: 0px; padding-right: 0px; list-style: none; }
.outline-content ul { margin-top: 0px; margin-bottom: 0px; }
.outline-content strong { font-weight: 400; }
.outline-expander { width: 1rem; height: 1.42857rem; position: relative; display: table-cell; vertical-align: middle; cursor: pointer; padding-left: 4px; }
.outline-expander::before { content: ""; position: relative; font-family: Ionicons; display: inline-block; font-size: 8px; vertical-align: middle; }
.outline-item { padding-top: 3px; padding-bottom: 3px; cursor: pointer; }
.outline-expander:hover::before { content: ""; }
.outline-h1 > .outline-item { padding-left: 0px; }
.outline-h2 > .outline-item { padding-left: 1em; }
.outline-h3 > .outline-item { padding-left: 2em; }
.outline-h4 > .outline-item { padding-left: 3em; }
.outline-h5 > .outline-item { padding-left: 4em; }
.outline-h6 > .outline-item { padding-left: 5em; }
.outline-label { cursor: pointer; display: table-cell; vertical-align: middle; text-decoration: none; color: inherit; }
.outline-label:hover { text-decoration: underline; }
.outline-item:hover { border-color: rgb(245, 245, 245); background-color: var(--item-hover-bg-color); }
.outline-item:hover { margin-left: -28px; margin-right: -28px; border-left: 28px solid transparent; border-right: 28px solid transparent; }
.outline-item-single .outline-expander::before, .outline-item-single .outline-expander:hover::before { display: none; }
.outline-item-open > .outline-item > .outline-expander::before { content: ""; }
.outline-children { display: none; }
.info-panel-tab-wrapper { display: none; }
.outline-item-open > .outline-children { display: block; }
.typora-export .outline-item { padding-top: 1px; padding-bottom: 1px; }
.typora-export .outline-item:hover { margin-right: -8px; border-right: 8px solid transparent; }
.typora-export .outline-expander::before { content: "+"; font-family: inherit; top: -1px; }
.typora-export .outline-expander:hover::before, .typora-export .outline-item-open > .outline-item > .outline-expander::before { content: "−"; }
.typora-export-collapse-outline .outline-children { display: none; }
.typora-export-collapse-outline .outline-item-open > .outline-children, .typora-export-no-collapse-outline .outline-children { display: block; }
.typora-export-no-collapse-outline .outline-expander::before { content: "" !important; }
.typora-export-show-outline .outline-item-active > .outline-item .outline-label { font-weight: 700; }
.md-inline-math-container mjx-container { zoom: 0.95; }


:root {
    --side-bar-bg-color: #fafafa;
    --control-text-color: #777;
}

@include-when-export url(https://fonts.loli.net/css?family=Open+Sans:400italic,700italic,700,400&subset=latin,latin-ext);

/* open-sans-regular - latin-ext_latin */
  /* open-sans-italic - latin-ext_latin */
    /* open-sans-700 - latin-ext_latin */
    /* open-sans-700italic - latin-ext_latin */
  html {
    font-size: 16px;
    -webkit-font-smoothing: antialiased;
}

body {
    font-family: "Open Sans","Clear Sans", "Helvetica Neue", Helvetica, Arial, 'Segoe UI Emoji', sans-serif;
    color: rgb(51, 51, 51);
    line-height: 1.6;
}

#write {
    max-width: 860px;
  	margin: 0 auto;
  	padding: 30px;
    padding-bottom: 100px;
}

@media only screen and (min-width: 1400px) {
	#write {
		max-width: 1024px;
	}
}

@media only screen and (min-width: 1800px) {
	#write {
		max-width: 1200px;
	}
}

#write > ul:first-child,
#write > ol:first-child{
    margin-top: 30px;
}

a {
    color: #4183C4;
}
h1,
h2,
h3,
h4,
h5,
h6 {
    position: relative;
    margin-top: 1rem;
    margin-bottom: 1rem;
    font-weight: bold;
    line-height: 1.4;
    cursor: text;
}
h1:hover a.anchor,
h2:hover a.anchor,
h3:hover a.anchor,
h4:hover a.anchor,
h5:hover a.anchor,
h6:hover a.anchor {
    text-decoration: none;
}
h1 tt,
h1 code {
    font-size: inherit;
}
h2 tt,
h2 code {
    font-size: inherit;
}
h3 tt,
h3 code {
    font-size: inherit;
}
h4 tt,
h4 code {
    font-size: inherit;
}
h5 tt,
h5 code {
    font-size: inherit;
}
h6 tt,
h6 code {
    font-size: inherit;
}
h1 {
    font-size: 2.25em;
    line-height: 1.2;
    border-bottom: 1px solid #eee;
}
h2 {
    font-size: 1.75em;
    line-height: 1.225;
    border-bottom: 1px solid #eee;
}

/*@media print {
    .typora-export h1,
    .typora-export h2 {
        border-bottom: none;
        padding-bottom: initial;
    }

    .typora-export h1::after,
    .typora-export h2::after {
        content: "";
        display: block;
        height: 100px;
        margin-top: -96px;
        border-top: 1px solid #eee;
    }
}*/

h3 {
    font-size: 1.5em;
    line-height: 1.43;
}
h4 {
    font-size: 1.25em;
}
h5 {
    font-size: 1em;
}
h6 {
   font-size: 1em;
    color: #777;
}
p,
blockquote,
ul,
ol,
dl,
table{
    margin: 0.8em 0;
}
li>ol,
li>ul {
    margin: 0 0;
}
hr {
    height: 2px;
    padding: 0;
    margin: 16px 0;
    background-color: #e7e7e7;
    border: 0 none;
    overflow: hidden;
    box-sizing: content-box;
}

li p.first {
    display: inline-block;
}
ul,
ol {
    padding-left: 30px;
}
ul:first-child,
ol:first-child {
    margin-top: 0;
}
ul:last-child,
ol:last-child {
    margin-bottom: 0;
}
blockquote {
    border-left: 4px solid #dfe2e5;
    padding: 0 15px;
    color: #777777;
}
blockquote blockquote {
    padding-right: 0;
}
table {
    padding: 0;
    word-break: initial;
}
table tr {
    border: 1px solid #dfe2e5;
    margin: 0;
    padding: 0;
}
table tr:nth-child(2n),
thead {
    background-color: #f8f8f8;
}
table th {
    font-weight: bold;
    border: 1px solid #dfe2e5;
    border-bottom: 0;
    margin: 0;
    padding: 6px 13px;
}
table td {
    border: 1px solid #dfe2e5;
    margin: 0;
    padding: 6px 13px;
}
table th:first-child,
table td:first-child {
    margin-top: 0;
}
table th:last-child,
table td:last-child {
    margin-bottom: 0;
}

.CodeMirror-lines {
    padding-left: 4px;
}

.code-tooltip {
    box-shadow: 0 1px 1px 0 rgba(0,28,36,.3);
    border-top: 1px solid #eef2f2;
}

.md-fences,
code,
tt {
    border: 1px solid #e7eaed;
    background-color: #f8f8f8;
    border-radius: 3px;
    padding: 0;
    padding: 2px 4px 0px 4px;
    font-size: 0.9em;
}

code {
    background-color: #f3f4f4;
    padding: 0 2px 0 2px;
}

.md-fences {
    margin-bottom: 15px;
    margin-top: 15px;
    padding-top: 8px;
    padding-bottom: 6px;
}


.md-task-list-item > input {
  margin-left: -1.3em;
}

@media print {
    html {
        font-size: 13px;
    }
    table,
    pre {
        page-break-inside: avoid;
    }
    pre {
        word-wrap: break-word;
    }
}

.md-fences {
	background-color: #f8f8f8;
}
#write pre.md-meta-block {
	padding: 1rem;
    font-size: 85%;
    line-height: 1.45;
    background-color: #f7f7f7;
    border: 0;
    border-radius: 3px;
    color: #777777;
    margin-top: 0 !important;
}

.mathjax-block>.code-tooltip {
	bottom: .375rem;
}

.md-mathjax-midline {
    background: #fafafa;
}

#write>h3.md-focus:before{
	left: -1.5625rem;
	top: .375rem;
}
#write>h4.md-focus:before{
	left: -1.5625rem;
	top: .285714286rem;
}
#write>h5.md-focus:before{
	left: -1.5625rem;
	top: .285714286rem;
}
#write>h6.md-focus:before{
	left: -1.5625rem;
	top: .285714286rem;
}
.md-image>.md-meta {
    /*border: 1px solid #ddd;*/
    border-radius: 3px;
    padding: 2px 0px 0px 4px;
    font-size: 0.9em;
    color: inherit;
}

.md-tag {
    color: #a7a7a7;
    opacity: 1;
}

.md-toc { 
    margin-top:20px;
    padding-bottom:20px;
}

.sidebar-tabs {
    border-bottom: none;
}

#typora-quick-open {
    border: 1px solid #ddd;
    background-color: #f8f8f8;
}

#typora-quick-open-item {
    background-color: #FAFAFA;
    border-color: #FEFEFE #e5e5e5 #e5e5e5 #eee;
    border-style: solid;
    border-width: 1px;
}

/** focus mode */
.on-focus-mode blockquote {
    border-left-color: rgba(85, 85, 85, 0.12);
}

header, .context-menu, .megamenu-content, footer{
    font-family: "Segoe UI", "Arial", sans-serif;
}

.file-node-content:hover .file-node-icon,
.file-node-content:hover .file-node-open-state{
    visibility: visible;
}

.mac-seamless-mode #typora-sidebar {
    background-color: #fafafa;
    background-color: var(--side-bar-bg-color);
}

.md-lang {
    color: #b4654d;
}

/*.html-for-mac {
    --item-hover-bg-color: #E6F0FE;
}*/

#md-notification .btn {
    border: 0;
}

.dropdown-menu .divider {
    border-color: #e5e5e5;
    opacity: 0.4;
}

.ty-preferences .window-content {
    background-color: #fafafa;
}

.ty-preferences .nav-group-item.active {
    color: white;
    background: #999;
}

.menu-item-container a.menu-style-btn {
    background-color: #f5f8fa;
    background-image: linear-gradient( 180deg , hsla(0, 0%, 100%, 0.8), hsla(0, 0%, 100%, 0)); 
}

</style>