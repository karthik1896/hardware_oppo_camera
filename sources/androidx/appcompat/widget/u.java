package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.core.f.f;

/* compiled from: AppCompatTextClassifierHelper */
final class u {

    /* renamed from: a  reason: collision with root package name */
    private TextView f464a;

    /* renamed from: b  reason: collision with root package name */
    private TextClassifier f465b;

    u(TextView textView) {
        this.f464a = (TextView) f.a(textView);
    }

    public void a(TextClassifier textClassifier) {
        this.f465b = textClassifier;
    }

    public TextClassifier a() {
        TextClassifier textClassifier = this.f465b;
        if (textClassifier != null) {
            return textClassifier;
        }
        TextClassificationManager textClassificationManager = (TextClassificationManager) this.f464a.getContext().getSystemService(TextClassificationManager.class);
        if (textClassificationManager != null) {
            return textClassificationManager.getTextClassifier();
        }
        return TextClassifier.NO_OP;
    }
}
