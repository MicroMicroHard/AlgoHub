package DesignPattern.visitor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 蔚蔚樱
 * @version 1.0
 * @date 2019-1-6 ����04:33:14
 * @authorEmail micromicrohard@outlook.com
 * @description
 * @URL
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PositionCom {
    String PName;
    int Salary;
}

//������
interface Accept {

    void acceptable(Visitor v);
}

//����Ա�����ݽṹ
class PositionWaiter extends PositionCom implements Accept {

    public PositionWaiter(String PName, int Salary) {
        super(PName, Salary);
    }

    
    public void acceptable(Visitor v) {
        v.visit(this);
    }
}

//��������ݽṹ
class PositionManager extends PositionCom implements Accept {

    int stock;

    public PositionManager(String PName, int Salary, int stock) {
        super(PName, Salary);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    
    public void acceptable(Visitor v) {
        v.visit(this);
    }
}

//���˵����ݽṹ
class PositionWorker extends PositionCom implements Accept {

    double subsidy;

    public PositionWorker(String PName, int Salary, double subsidy) {
        super(PName, Salary);
        this.subsidy = subsidy;
    }

    public double getSubsidy() {
        return subsidy;
    }

    public void setSubsidy(double subsidy) {
        this.subsidy = subsidy;
    }

    
    public void acceptable(Visitor v) {
        
        v.visit(this);
    }
}