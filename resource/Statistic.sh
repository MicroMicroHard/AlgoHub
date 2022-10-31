

javaPath=../AlgorithmJavaVersion/src
goPath=../AlgorithmGoVersion/src


#------Java _CodeNum Static
javaAlg_CodeNum=$(       find $javaPath/Algorithm/     -iname "*.java" |grep -v Test |wc -l)
javaDS_CodeNum=$(        find $javaPath/DataStructure/        -iname "*.java" |grep -v Test |wc -l)
javaDesign_CodeNum=$(    find  $javaPath/DesignPattern/   -iname "*.java" |grep -v Test |wc -l)
#------Java UT _CodeNum Static
javaAlgUT_CodeNum=$(     find $javaPath/UnitTest/AlgorithmTest  -iname "*.java" |grep  Test |wc -l)
javaDSUT_CodeNum=$(      find $javaPath/UnitTest/DataStructureTest     -iname "*.java" |grep  Test |wc -l)
javaDesignUT_CodeNum=$(  find $javaPath/UnitTest/DesignPatternTest -iname "*.java" |grep  Test |wc -l)
#------Java _CodeLine Static
javaAlg_CodeLine=$(      find $javaPath/Algorithm/  -name "*.java"|grep -v Test|xargs cat |wc -l)
javaDS_CodeLine=$(       find $javaPath/DataStructure      -name "*.java"|grep -v Test|xargs cat |wc -l)
javaDesign_CodeLine=$(   find $javaPath/DesignPattern  -name "*.java"|grep -v Test|xargs cat |wc -l)
#------Java UT _CodeLine Static
javaAlgUT_CodeLine=$(    find $javaPath/UnitTest/AlgorithmTest   -name "*.java"|xargs cat |wc -l)
javaDSUT_CodeLine=$(     find $javaPath/UnitTest/DataStructureTest      -name "*.java"|xargs cat |wc -l)
javaDesignUT_CodeLine=$( find $javaPath/UnitTest/DesignPatternTest  -name "*.java"|xargs cat |wc -l)
#------Java Total Static
#javaTotal_CodeNum=$((   javaAlg_CodeNum   + javaDS_CodeNum   + javaDesign_CodeNum))
javaTotal_CodeNum=$(     find $javaPath/  -name "*.java"|grep -v Test|grep -v test|wc -l)
#javaTotalUT_CodeNum=$(( javaAlgUT_CodeNum + javaDSUT_CodeNum + javaDesignUT_CodeNum))
javaTotalUT_CodeNum=$(   find $javaPath/UnitTest  -name "*.java"|grep -v Test|grep -v test|wc -l)
javaTotal_CodeLine=$((   javaAlg_CodeLine  + javaDS_CodeLine  + javaDesign_CodeLine))
javaTotalUT_CodeLine=$(( javaAlgUT_CodeLine+ javaDSUT_CodeLine+ javaDesignUT_CodeLine))


#------Go _CodeNum Static
goAlg_CodeNum=$(      find $goPath/Algorithm/     -iname "*.go" |grep -v Test |wc -l)
goDS_CodeNum=$(       find $goPath/DataStructure/        -iname "*.go" |grep -v Test |wc -l)
goDesign_CodeNum=$(   find  $goPath/DesignPattern/   -iname "*.go" |grep -v Test |wc -l)
#------Go UT _CodeNum Static
goAlgUT_CodeNum=$(    find $goPath/UnitTest/AlgorithmTest  -iname "*.go" |grep  Test |wc -l)
goDSUT_CodeNum=$(     find $goPath/UnitTest/DataStructureTest     -iname "*.go" |grep  Test |wc -l)
goDesignUT_CodeNum=$( find $goPath/UnitTest/DesignPatternTest -iname "*.go" |grep  Test |wc -l)
#------Go _CodeLine Static
goAlg_CodeLine=$(     find $goPath/Algorithm/  -name "*.go"|grep -v Test|xargs cat |wc -l)
goDS_CodeLine=$(      find $goPath/DataStructure      -name "*.go"|grep -v Test|xargs cat |wc -l)
goDesign_CodeLine=$(  find $goPath/DesignPattern  -name "*.go"|grep -v Test|xargs cat |wc -l)
#------Go UT _CodeLine Static
goAlgUT_CodeLine=$(   find $goPath/UnitTest/AlgorithmTest   -name "*.go"|xargs cat |wc -l)
goDSUT_CodeLine=$(    find $goPath/UnitTest/DataStructureTest      -name "*.go"|xargs cat |wc -l)
goDesignUT_CodeLine=$(find $goPath/UnitTest/DesignPatternTest  -name "*.go"|xargs cat |wc -l)
#------Go Total Static
goTotal_CodeNum=$((   goAlg_CodeNum    + goDS_CodeNum    + goDesign_CodeNum))
goTotalUT_CodeNum=$(( goAlgUT_CodeNum  + goDSUT_CodeNum  + goDesignUT_CodeNum))
goTotal_CodeLine=$((  goAlg_CodeLine   + goDS_CodeLine   + goDesign_CodeLine))
goTotalUT_CodeLine=$((goAlgUT_CodeLine + goDSUT_CodeLine + goDesignUT_CodeLine))


#------Total Static
javaAll_CodeNum=$(( javaTotal_CodeNum  + javaTotalUT_CodeNum))
javaAll_CodeLine=$((javaTotal_CodeLine + javaTotalUT_CodeLine))
goAll_CodeNum=$((   goTotal_CodeNum    + goTotalUT_CodeNum))
goAll_CodeLine=$((  goTotal_CodeLine   + goTotalUT_CodeLine))

javaTotal_CodeUTCoverage=$( echo "scale=2; $javaTotalUT_CodeNum/ $javaTotal_CodeNum" |bc -l)
javaAlg_CodeUTCoverage=$(   echo "scale=2; $javaAlgUT_CodeNum/ $javaAlg_CodeNum" |bc -l)
javaDS_CodeUTCoverage=$(    echo "scale=2; $javaDSUT_CodeNum/ $javaDS_CodeNum" |bc -l)
javaDesign_CodeUTCoverage=$(echo "scale=2; $javaDesignUT_CodeNum/ $javaDesign_CodeNum" |bc -l)

goTotal_CodeUTCoverage=$( echo "scale=2; $goTotalUT_CodeNum/ $goTotal_CodeNum" |bc -l)
goAlg_CodeUTCoverage=$(   echo "scale=2; $goAlgUT_CodeNum/ $goAlg_CodeNum" |bc -l)
goDS_CodeUTCoverage=$(    echo "scale=2; $goDSUT_CodeNum/ $goDS_CodeNum" |bc -l)
goDesign_CodeUTCoverage=$(echo "scale=2; $goDesignUT_CodeNum/ $goDesign_CodeNum" |bc -l)

#-------
echo "## 代码统计"
echo "\`\`\`mermaid"
echo "pie"
echo "title 各语言代码数量统计"
echo "\"Algorithm_Java\"" :     $((javaAlg_CodeNum))
echo "\"DataStructure_Java\"" : $((javaDS_CodeNum))
echo "\"DesignPattern_Java\"" : $((javaDesign_CodeNum))
echo "\"Algorithm_Go\"" :       $((goAlg_CodeNum))
echo "\"DataStructure_Go\"" :   $((goDS_CodeNum))
echo "\"DesignPattern_Go\"" :   $((goDesign_CodeNum))

echo "\`\`\`"


#------Java Show
otherCodeNum=$(( javaTotal_CodeNum  - javaAlg_CodeNum - javaDS_CodeNum - javaDesign_CodeNum ))
otherCodeUT_CodeNum=$(( javaTotalUT_CodeNum - javaAlgUT_CodeNum - javaDSUT_CodeNum - javaDesignUT_CodeNum ))
otherCodeNum_CodeUTCoverage=$(echo "scale=2; $otherCodeUT_CodeNum/ $otherCodeNum" |bc -l)

echo "### 📙[Java语言入口](https://gitee.com/ljfirst/AlgorithmPractice/tree/master/AlgorithmJavaVersion)"
echo "![Java项目代码总数量](https://img.shields.io/badge/Java_Code_Num-"$javaTotal_CodeNum"-brightgreen.svg)"
echo "![Java项目代码总行数](https://img.shields.io/badge/Java_Code_Line-"$javaTotal_CodeLine"-blue.svg)"
echo ""
echo "| JavaVersion |  Total  | Algorithm  | DataStructure  | DesignPattern | Others |"
echo "| --------    | :-----: |  :----:    |  :-----:       |    :-----:    | :-----:|"
echo "| Code        | $javaTotal_CodeNum   | $javaAlg_CodeNum   |  $javaDS_CodeNum      |  $javaDesign_CodeNum | $otherCodeNum |"
echo "| UT Coverage | $javaTotal_CodeUTCoverage"%"  | $javaAlg_CodeUTCoverage"%"        | $javaDS_CodeUTCoverage"%"           | $javaDesign_CodeUTCoverage"%"  | $otherCodeNum_CodeUTCoverage |"

#------Go Show
echo ""
echo "### 📘[go语言入口](https://gitee.com/ljfirst/AlgorithmPractice/tree/master/AlgorithmGoVersion)"
echo "![Go项目代码总数量](https://img.shields.io/badge/GO_Code_Num-"$goTotal_CodeNum"-brightgreen.svg)"
echo "![Go项目代码总行数](https://img.shields.io/badge/GO_Code_Line-"$goTotal_CodeLine"-blue.svg)"
echo ""
echo "| GoVersion  |  Total  | Algorithm  | DataStructure  | DesignPattern |"
echo "| --------   | :-----: |  :----:    |  :-----:       |    :-----:    |"
echo "| Code       | $goTotal_CodeNum     | $goAlg_CodeNum    |  $goDS_CodeNum      |  $goDesign_CodeNum  |"
echo "| UT Coverage| $goTotal_CodeUTCoverage"%"  | $goAlg_CodeUTCoverage"%"        | $goDS_CodeUTCoverage"%"           | $goDesign_CodeUTCoverage"%"  |"
echo ""

