package com.photify.controller.upload;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.photify.meta.UploadedDataMeta;
import com.photify.service.UploadService;

public class DeleteController extends Controller {

    private UploadService service = new UploadService();

    private UploadedDataMeta meta = UploadedDataMeta.get();

    @Override
    public Navigation run() throws Exception {
        service.delete(asKey(meta.key));
        return redirect(basePath);
    }
}
