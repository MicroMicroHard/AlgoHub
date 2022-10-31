package Utils

import (
	"AlgorithmPractice/src/Algorithm/dynamic/lcs"
	"encoding/json"
	"fmt"
	"strings"
)

// FileTools
// @author: 蔚蔚樱
// @date: 2022/8/210:26
// @author—Email: micromicrohard@outlook.com
// @description:
// @blogURL:
type FileTools struct {
}

// 定制监控文件处理

func DealAlertFile(fileContext string) []AlertEntity {

	AlertEntityArr := make([]AlertEntity, 0)
	AlertEntityArrReal := make([]AlertEntity, 0)
	err := json.Unmarshal([]byte(fileContext), &AlertEntityArr)
	if err != nil {
		fmt.Println("err:", err)
	}

	for _, entity := range AlertEntityArr {
		if entity.IsDisabled == 1 {
			fmt.Println("失效告警:", entity.DisplayName)
			continue
		}
		AlertEntityArrReal = append(AlertEntityArrReal, entity)
	}
	return AlertEntityArrReal
}

// 根据Lcs算法将 相似文件名 聚类

func ClusteringFilesByLcs(alertEntityArr []AlertEntity, similarity int) map[string][]AlertEntity {
	similarityMap := make(map[string][]AlertEntity)
	lcsInstance := &lcs.LCS_Dynamic{}
	//existMap := make(map[string]bool)

	for i, entity := range alertEntityArr {
		for j := i + 1; j < len(alertEntityArr); j++ {

			/*if _, exist := existMap[alertEntityArr[j].DisplayName]; exist {
				continue
			}*/

			a := strings.ReplaceAll(entity.DisplayName, "Algo-algorithm", "")
			b := strings.ReplaceAll(alertEntityArr[j].DisplayName, "Algo-algorithm", "")
			similar := lcsInstance.GetCommonLength(a, b)
			if similar > similarity {
				fmt.Println("----------------")
				fmt.Println(entity.DisplayName)
				fmt.Println(alertEntityArr[j].DisplayName)
				fmt.Println("----------------")

			} /*
				if len(similarityMap[entity.DisplayName]) == 0 {
					similarityMap[entity.DisplayName] = make([]AlertEntity, 0)
				}

				if !existMap[entity.DisplayName] {
					existMap[entity.DisplayName] = true
					similarityMap[entity.DisplayName] = append(similarityMap[entity.DisplayName], entity)
				}
				if !existMap[alertEntityArr[j].DisplayName] {
					existMap[alertEntityArr[j].DisplayName] = true
					similarityMap[entity.DisplayName] = append(similarityMap[entity.DisplayName], entity)
				}*/
		}
	}
	return similarityMap
}
