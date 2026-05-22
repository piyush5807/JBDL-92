package com.example.library_system.dtos;

import com.example.library_system.models.TxnType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateTxnRequest {

    @Positive
    private Integer bookId;

    @Positive
    private Integer studentId;

    @NotNull
    private TxnType txnType;

}
