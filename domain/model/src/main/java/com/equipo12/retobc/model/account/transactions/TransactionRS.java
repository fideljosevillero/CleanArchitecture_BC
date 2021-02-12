package com.equipo12.retobc.model.account.transactions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class TransactionRS {
   private String id;
   private String postedDate;
   private String description;
   private float amount;
   private String type;
   private String reference1;
   private String reference2;
   private String reference3;
   private String checkNumber;
}
