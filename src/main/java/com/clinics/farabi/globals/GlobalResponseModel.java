package com.clinics.farabi.globals;

import java.util.List;

public record GlobalResponseModel(Boolean success, List<String> message, Object data) {
}
