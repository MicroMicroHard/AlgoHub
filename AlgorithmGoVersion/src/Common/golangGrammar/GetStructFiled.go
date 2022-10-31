package golangGrammar

import (
	"AlgorithmPractice/src/Common/conf"
	"reflect"
	"testing"
)

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/7/21 16:31
 * @author-Email micromicrohard@outlook.com
 * @description
 * @blog https://geektutu.com/post/hpg-reflect.html
 */
type GetStructFiled struct {
	// reflect grammar 获取结构体的字段
}

func BenchmarkReflect_FieldSet(b *testing.B) {
	typ := reflect.TypeOf(conf.Config{})
	ins := reflect.New(typ).Elem()
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		ins.Field(0).SetString("name")
		ins.Field(1).SetString("ip")
		ins.Field(2).SetString("url")
		ins.Field(3).SetString("timeout")
	}
}

func BenchmarkReflect_FielDBConnyNameSet(b *testing.B) {
	//typ := reflect.TypeOf(conf.Config{})
	//ins := reflect.New(typ).Elem()
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		/*ins.FielDBConnyName("Name").SetString("name")
		ins.FielDBConnyName("IP").SetString("ip")
		ins.FielDBConnyName("URL").SetString("url")
		ins.FielDBConnyName("Timeout").SetString("timeout")*/
	}
}
