package com.root.rentalheive.dto;

import com.root.rentalheive.enums.Status;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DemandDto {
    Long userId;
    Status status;
}
