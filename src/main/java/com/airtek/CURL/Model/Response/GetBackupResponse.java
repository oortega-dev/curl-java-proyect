package com.airtek.CURL.Model.Response;

import com.airtek.CURL.Entity.Backup;
import com.airtek.CURL.Model.Enums.RequestType;

import java.time.LocalDateTime;

public class GetBackupResponse {
    private String name;
    private RequestType typeChanged;
    private String bodyChanged;
    private String urlChanged;
    private String employeeDocumentId;
    private LocalDateTime modified;

    public GetBackupResponse(Backup backup) {
        this.name = backup.getName();
        this.typeChanged = backup.getTypeChanged();
        this.bodyChanged = backup.getBodyChanged();
        this.urlChanged = backup.getUrlChanged();
        this.employeeDocumentId = backup.getEmployeeChange().getDocumentId();
        this.modified = backup.getModified();
    }
}
