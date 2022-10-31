package DBConn

import "C"
import "fmt"

type UTDataEntity struct {
	ID            *int64
	Input         *string // 输入
	Output        *string // 输出
	ClassName     *string // 类名
	InputDesc     *string // 输入描述
	OutputDesc    *string // 输出描述
	ClassDescribe *string // 题目描述
}

/**SQL对象实体
 * 输出 int      的Input {@link UTDataEntity#getIntInput}
 * 输出 int[]    的Input {@link UTDataEntity#getIntArrayInput}
 * 输出 int[][]  的Input {@link UTDataEntity#getIntMatrixInput}
 * 输出 String   的Input {@link UTDataEntity#getStringInput}
 * 输出 String[] 的Input {@link UTDataEntity#getStringArrayInput}
 * 输出 Nodelj   的Input {@link UTDataEntity#getNodeljInput}
 * 输出 Nodelj[] 的Input {@link UTDataEntity#getNodeljArrayInput}
 * <p>
 * 输出 int      的Output {@link UTDataEntity#getIntOutput}
 * 输出 int[]    的Output {@link UTDataEntity#getIntArrayOutput}
 * 输出 int[][]  的Output {@link UTDataEntity#getIntMatrixOutput}
 * 输出 String   的Output {@link UTDataEntity#getStringOutput}
 * 输出 String[] 的Output {@link UTDataEntity#getStringArrayOutput}
 * 输出 Nodelj   的Output {@link UTDataEntity#getNodeljOutput}
 * 输出 Nodelj[] 的Output {@link UTDataEntity#getNodeljArrayOutput}
 */

func (entity *UTDataEntity) GetInput() string {
	return *entity.Input
}

func (entity *UTDataEntity) GetOutput() string {
	return *entity.Output
}

func (entity *UTDataEntity) Print() {
	var id int64 = -100
	if entity.ID != nil {
		id = *entity.ID
	}
	DBConnEntity := fmt.Sprintf("UTDataEntity: ID: %d"+
		"\n                   Input: %s"+
		"\n                   Output: %s"+
		"\n                   className: %s",
		id, *(entity.Input), *(entity.Output), *(entity.ClassName))
	fmt.Println(DBConnEntity)
}

func (entity *UTDataEntity) TableName() string {
	return "ut_test_data"
}
