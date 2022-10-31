package Topic100

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/10/9 18:21
 * @author-Email micromicrohard@outlook.com
 * @description
 */
type practice struct {
}

/*func GetSuffix(preStr, orderStr string) string {
	if preStr == "" || orderStr == "" || len(preStr) != len(orderStr) {
		return "" // error
	}
	suffStr := make([]string, 0)

	deep(string(preStr[0]), orderStr, &suffStr)
	return cast.ToString(suffStr).revise
}

func deep(mid, orderStrValue string, answer *[]string) {
	*answer = append(*answer, mid)
	var index int
	for i, i2 := range orderStrValue {
		if cast.ToInt32(mid) == i2 {
			index = i
			break
		}
	}
	preStrValuePartTwo
	orderStrValuePartTwo := orderStrValue[index+1:]

	preStrValuePartOne
	orderStrValuePartOne := orderStrValue[:index]

	deep(string(orderStrValuePartOne[0]), partOne, answer)
	deep(string(orderStrValuePartTwo[0]), partTwo, answer)
}*/
