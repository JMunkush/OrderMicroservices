package io.munkush.app;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class OrderRequest {
    private Long id;
    private String username;
    private String orderName;
    private boolean isManager;
}
