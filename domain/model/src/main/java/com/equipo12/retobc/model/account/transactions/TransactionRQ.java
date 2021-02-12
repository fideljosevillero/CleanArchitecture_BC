package com.equipo12.retobc.model.account.transactions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class TransactionRQ {
   private String startDate;
   private String endDate;
   private float minAmount;
   private float maxAmount;
   private String type;
   private String checkNumber;
   private String group;
   private String description;
}
