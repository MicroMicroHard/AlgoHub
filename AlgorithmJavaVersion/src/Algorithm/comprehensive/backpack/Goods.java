package Algorithm.comprehensive.backpack;

import lombok.*;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2020/10/29
 * @author—Email micromicrohard@outlook.com
 * @blogURL https://blog.csdn.net/Micro_Micro_Hard
 * @description 背包问题中的 物品
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Goods {

    @NonNull
    int prices;
    @NonNull
    int weight;

    String goodsName;
    @NonNull
    double pw;
}
