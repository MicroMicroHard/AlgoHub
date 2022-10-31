package inherit

import "fmt"

// Father
// @author: 蔚蔚樱
// @date: 2022/8/2914:42
// @author—Email: micromicrohard@outlook.com
// @description:
// @blogURL:
type Father struct { // grammar： 继承  inherit
}

func (p *Father) funcMethod(x, y int, ff func(x, y int)) {
	fmt.Println("i am father begin")
	ff(x, y)
	fmt.Println("i am father end")
}
