package com.sic.springboot_maven_fourth.entiy;

import com.sic.springboot_maven_fourth.pojo.Selfjoincontractcoefficient;

import java.util.List;

public class CalSelfCoefficients {
    private List<Selfjoincontractcoefficient> selfjoincontractcoefficientList;

    public CalSelfCoefficients(List<Selfjoincontractcoefficient> selfjoincontractcoefficientList) {
        this.selfjoincontractcoefficientList = selfjoincontractcoefficientList;
    }

    public List<Selfjoincontractcoefficient> calSelfCoefficient() {
        double temp = 0;
        for (Selfjoincontractcoefficient selfjoincontractcoefficient : selfjoincontractcoefficientList) {
            temp = selfjoincontractcoefficient.getCurrentSelfJoinContracts() / selfjoincontractcoefficient.getCurrentNewOrders();
            if (temp >= 0.35) {
                selfjoincontractcoefficient.setSelfJoinContractCoefficient(1);
            } else if (temp >= 0.9 * 0.35) {
                selfjoincontractcoefficient.setSelfJoinContractCoefficient(0.9);
            } else {
                selfjoincontractcoefficient.setSelfJoinContractCoefficient(0.8);
            }
        }
        return selfjoincontractcoefficientList;
    }
}
