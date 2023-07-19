package com.diegodelacruz.notificationtestservice.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Integer id;

    @NotNull
    @NotEmpty
    @Size(min = 4, max = 50)
    private String nameUser;

    @NotNull
    @Size(min = 4, max = 100)
    private String emailUser;

    @NotNull
    @Size(min = 4, max = 15)
    private String phoneNumberUser;

    @NotNull
    private List<CategoryDTO> listCategories;

    @NotNull
    private List<NotificationDTO> listNotifications;

}
