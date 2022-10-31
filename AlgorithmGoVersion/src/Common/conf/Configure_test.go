package conf

import "testing"

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/6/25 12:46 上午
 * @author-Email micromicrohard@outlook.com
 * @description
 */

func TestGetConfig(t *testing.T) {

	GetConfig()
	GetConfig() // 只会初始化一次
	GetConfig()
}
