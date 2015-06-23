package com.photify.controller.upload;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.upload.FileItem;

import com.photify.service.UploadService;

public class UploadController extends Controller {

    private UploadService service = new UploadService();

    @Override
    public Navigation run() {
        FileItem formFile = requestScope("formFile");
        service.upload(formFile);
        return redirect(basePath);
    }
}