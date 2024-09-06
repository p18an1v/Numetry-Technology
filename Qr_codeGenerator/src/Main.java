import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.File;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.QRCodeWriter;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the QR code data (URL, text, etc.): ");
            String qrCodeData = scanner.nextLine();

            String filePath = "C:\\QRFolder\\QRofWebsite.png";

            generateQRCode(qrCodeData, filePath);
            System.out.println("QR Code image created successfully!");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    static void generateQRCode(String qrCodeData, String filePath) throws WriterException, IOException {
        String charset = "UTF-8"; // or "ISO-8859-1"
        Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<>();
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        BitMatrix matrix = new QRCodeWriter().encode(
                new String(qrCodeData.getBytes(charset), charset),
                BarcodeFormat.QR_CODE, 200, 200, hintMap);
        MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath.lastIndexOf('.') + 1), new File(filePath));
    }
}