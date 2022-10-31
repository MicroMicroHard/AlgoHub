package string_study

import (
	"fmt"
	"regexp"
	"strings"
	"testing"
)

// ReviseString_test.go
// @author: 蔚蔚樱
// @date: 2022/5/2422:39
// @author—Email: micromicrohard@outlook.com
// @description:
// @blogURL:

func TestReviseString_revis1e(t *testing.T) {
	sd := "{ \"result\": 0, \"message\": \"成功\", \"reference\": \"[('qqggy', 1075), ('qqggz', 808), ('qqgug', 240), ('qqguj', 482), ('qqgum', 1445), ('qqgun', 1630), ('qqgup', 1929), ('qqguq', 1867), ('qqgur', 1799), ('qqgus', 653), ('qqgut', 1798), ('qqguu', 1550), ('qqguv', 1892), ('qqguw', 1958), ('qqgux', 1860), ('qqguy', 1822), ('qqguz', 1655), ('qqgv5', 496), ('qqgv7', 124), ('qqgvh', 1866), ('qqgvj', 1774), ('qqgvk', 582), ('qqgvm', 184), ('qqgvn', 1509), ('qqgvp', 1406), ('qqgvq', 159), ('qqgvr', 14), ('qqu58', 7), ('qqu5b', 1618), ('qqu5c', 12), ('qquh0', 1772), ('qquh1', 47), ('qquh2', 1557), ('qquh3', 346), ('qquh8', 1665), ('qquh9', 1588), ('qquhb', 1592), ('qquhc', 1734), ('qquhd', 47), ('qquhf', 394), ('qquj0', 1923), ('qquj1', 1837), ('qquj2', 368), ('qquj3', 527), ('qquj4', 306), ('qquj6', 83)]\" }"

	sd = strings.ReplaceAll(sd, "(", "")
	sd = strings.ReplaceAll(sd, ")", "")
	sd = strings.ReplaceAll(sd, "'", "")
	sd = strings.ReplaceAll(sd, " ", "")
	sty := strings.Split(sd, ",")

	pattern := "[a-zA-Z]+"
	reg := regexp.MustCompile(pattern)

	for _, s := range sty {
		if reg.Match([]byte(s)) {
			fmt.Println("#", s, ",")
		}
	}

}

func TestReviseString_revise(t *testing.T) {
	type args struct {
		args string
	}
	tests := []struct {
		name string
		args args
		want string
	}{
		{
			"111",
			args{
				"123",
			},
			"321",
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			p := &ReviseString{}
			if got := p.revise(tt.args.args); got != tt.want {
				t.Errorf("revise() = %v, want %v", got, tt.want)
			}
		})
	}
}
