package viewtopdf;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.pdf.PdfDocument;
import android.view.View;

public class ViewToPdfDocument {

    public PdfDocument getPdfDocument(View view) {
        Bitmap bitmap = getBitmapWithBackground(view);
        return getPdfDocumentFromBitmap(bitmap);
    }

    private Bitmap getBitmapWithBackground(View view) {
        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        //background logic start
        Drawable background = view.getBackground();
        if (background != null)
            background.draw(canvas);
        else
            canvas.drawColor(Color.WHITE);
        //background logic end
        view.draw(canvas);
        return bitmap;
    }
    private PdfDocument getPdfDocumentFromBitmap(Bitmap bitmap) {
        PdfDocument document = new PdfDocument();
        PdfDocument.PageInfo pageInfo = new PdfDocument
                .PageInfo
                .Builder(bitmap.getWidth(), bitmap.getHeight(), 1)
                .create();
        PdfDocument.Page page = document.startPage(pageInfo);
        Canvas canvas = page.getCanvas();
        canvas.drawBitmap(bitmap, 0, 0, null);
        document.finishPage(page);
        return document;
    }
}
