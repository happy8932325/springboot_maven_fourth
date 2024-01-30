package com.sic.springboot_maven_fourth.pojo;


import lombok.Data;

@Data
public class Cash {


  private String contractNo;
  private String name;
  private String group;
  private double currentWithdrawal;
  private double currentRevenue;
  private double volumeCommission;
  private double currentProfit;
  private double targetProfit;
  private double profitCommission;
  private double selfJoinContractCoefficient;
  private double selfJoinContractCommission;
  private double cash;


}
