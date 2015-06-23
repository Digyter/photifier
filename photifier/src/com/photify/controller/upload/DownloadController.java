package com.photify.controller.upload;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.photify.meta.UploadedDataMeta;
import com.photify.model.UploadedData;
import com.photify.service.UploadService;

public class DownloadController extends Controller {

    private UploadService service = new UploadService();

    private UploadedDataMeta meta = UploadedDataMeta.get();

    @Override
    public Navigation run() throws Exception {
        UploadedData data =
            service.getData(asKey(meta.key), asLong(meta.version));
        byte[] bytes = service.getBytes(data);
        download(data.getFileName(), bytes);
        return null;
    }
}