package com.sic.springboot_maven_fourth.pojo;

import lombok.Data;

@Data
public class Provision {

  private String contractNo;
  private String name;
  private String group;
  private double currentRevenue;
  private double volumeCommission;
  private double profitCommission;
  private double selfJoinContractCommission;
  private double provision;

}
