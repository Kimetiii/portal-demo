package com.example.portalback.common.util;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.utils.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author LIN
 */
public class ZipUtils {

    public static void zip(List<File> files, String zipFilePath) throws IOException {
        File zipFile = new File(zipFilePath);
        try (ZipArchiveOutputStream out = new ZipArchiveOutputStream(zipFile)) {
            for (File file : files) {
                try (InputStream in = new FileInputStream(file)) {
                    ZipArchiveEntry entry = new ZipArchiveEntry(file, file.getName());
                    // 添加一个条目
                    out.putArchiveEntry(entry);
                    IOUtils.copy(in, out);
                    // 结束
                    out.closeArchiveEntry();
                }
            }
            out.finish();
        }
    }
}
