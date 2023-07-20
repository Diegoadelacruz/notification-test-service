package com.diegodelacruz.notificationtestservice.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationDTO {

    private Integer id;

    @NotNull
    @NotEmpty
    @Size(min = 4, max = 50)
    private String nameNotification;

    @NotNull
    @Size(min = 10, max = 255)
    private String descriptionNotification;
}
