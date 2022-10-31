package inherit

import (
	"fmt"
)

// Son
// @author: 蔚蔚樱
// @date: 2022/8/2914:43
// @author—Email: micromicrohard@outlook.com
// @description:
// @blogURL:
type Son struct {
	*Father
}

func (p *Son) Exec() {
	p.funcMethod(add)
}

func (p *Son) funcMethod(fc func(x, y int)) {
	i := 8
	j := 8
	p.Father.funcMethod(i, j, fc)

}

func add(x, y int) {
	fmt.Println(x + y)
}
