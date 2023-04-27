package com.oppo.camera;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.c;
import com.color.support.d.b;
import com.color.support.view.ColorFullPageStatement;
import com.color.support.widget.a;
import com.oppo.camera.ui.n;

/* compiled from: CameraStatementAlert */
public class j {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public c f3110a = null;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences f3111b = null;
    /* access modifiers changed from: private */
    public a c = null;
    /* access modifiers changed from: private */
    public ColorFullPageStatement d = null;
    /* access modifiers changed from: private */
    public TextView e = null;
    /* access modifiers changed from: private */
    public n f = null;
    /* access modifiers changed from: private */
    public boolean g = false;

    /* compiled from: CameraStatementAlert */
    public interface a {
        void a(boolean z);
    }

    public j(Activity activity, a aVar) {
        this.f3110a = (c) activity;
        this.c = aVar;
    }

    public boolean a(SharedPreferences sharedPreferences) {
        e.a("CameraStatementAlert", "showDialog, preferences: " + sharedPreferences);
        this.f3111b = sharedPreferences;
        SharedPreferences sharedPreferences2 = this.f3111b;
        if (sharedPreferences2 == null) {
            return false;
        }
        if (sharedPreferences2.getBoolean("pref_camera_statement_key", false)) {
            e.a("CameraStatementAlert", "showDialog, has show dialog");
            return false;
        }
        if (this.f == null) {
            View inflate = View.inflate(this.f3110a, R.layout.full_page_statement_bg, (ViewGroup) null);
            b.a((TextView) inflate.findViewById(R.id.statement_camera_summary), 4);
            inflate.setForceDarkAllowed(true);
            a(inflate);
            this.f.show(this.f3110a.j(), "StatementDialogFragment");
            this.g = true;
        }
        return true;
    }

    private void a(final View view) {
        this.f = new n();
        this.f.a((n.a) new n.a() {
            public void a() {
                j jVar = j.this;
                ColorFullPageStatement unused = jVar.d = jVar.f.a();
                j.this.d.setContainer(view);
                j.this.d.setButtonListener(new ColorFullPageStatement.a() {
                    public void a() {
                        j.this.f.dismiss();
                        boolean unused = j.this.g = false;
                        SharedPreferences.Editor edit = j.this.f3111b.edit();
                        edit.putBoolean("pref_camera_statement_agree", true);
                        edit.putBoolean("pref_camera_statement_key", true);
                        edit.apply();
                        if (j.this.c != null) {
                            j.this.c.a(true);
                        }
                    }

                    public void b() {
                        j.this.f.dismiss();
                        boolean unused = j.this.g = false;
                        SharedPreferences.Editor edit = j.this.f3111b.edit();
                        edit.putBoolean("pref_camera_statement_agree", false);
                        edit.putBoolean("pref_camera_statement_key", true);
                        edit.apply();
                        if (j.this.c != null) {
                            j.this.c.a(false);
                        }
                    }
                });
                ((TextView) j.this.d.findViewById(R.id.txt_exit)).setTextColor(j.this.f3110a.getResources().getColor(R.color.full_page_statement_exit_text_color));
                j jVar2 = j.this;
                TextView unused2 = jVar2.e = jVar2.d.getAppStatement();
                TextView f = j.this.e;
                j jVar3 = j.this;
                f.setText(jVar3.a(R.string.camera_statement_description, R.string.privacy_policy_link, jVar3.e));
                j.this.e.setMovementMethod(LinkMovementMethod.getInstance());
                j.this.e.setHighlightColor(j.this.f3110a.getResources().getColor(17170445));
            }
        });
    }

    /* access modifiers changed from: private */
    public CharSequence a(int i, int i2, final TextView textView) {
        String string = this.f3110a.getString(i2);
        String string2 = this.f3110a.getString(i, new Object[]{string});
        final int indexOf = string2.indexOf(string);
        final int length = string.length();
        com.color.support.widget.a aVar = new com.color.support.widget.a(this.f3110a);
        aVar.a(new a.C0057a() {
            public void a() {
                try {
                    Intent intent = new Intent("com.coloros.bootreg.activity.statementpage");
                    intent.putExtra("statement_intent_flag", 2);
                    j.this.f3110a.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        textView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int actionMasked = motionEvent.getActionMasked();
                int offsetForPosition = textView.getOffsetForPosition(motionEvent.getX(), motionEvent.getY());
                int i = indexOf;
                boolean z = offsetForPosition <= i || offsetForPosition >= i + length;
                if (actionMasked != 0) {
                    if (actionMasked == 1 || actionMasked == 3) {
                        textView.setPressed(false);
                        textView.postInvalidateDelayed(70);
                    }
                } else if (z) {
                    return true;
                } else {
                    textView.setPressed(true);
                    textView.invalidate();
                }
                return false;
            }
        });
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string2);
        spannableStringBuilder.setSpan(aVar, indexOf, length + indexOf, 33);
        return spannableStringBuilder;
    }

    public boolean a() {
        return this.g;
    }

    public void b() {
        e.a("CameraStatementAlert", "release");
        if (a() && !this.f.isStateSaved()) {
            this.f.dismiss();
        }
        this.g = false;
        this.c = null;
    }
}
