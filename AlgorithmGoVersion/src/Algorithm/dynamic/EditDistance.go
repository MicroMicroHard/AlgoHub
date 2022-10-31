package dynamic

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/10/11 22:15
 * @author-Email micromicrohard@outlook.com
 * @description
 */
type EditDistance struct {
}

func (e *EditDistance) GetDistanceMethod(source, pattern string) {
	if source == "" || pattern == "" {
		return
	}

}
