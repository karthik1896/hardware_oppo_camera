package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.a.g;
import androidx.core.g.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: Transition */
public abstract class m implements Cloneable {
    static final boolean DBG = false;
    private static final int[] DEFAULT_MATCH_ORDER = {2, 1, 3, 4};
    private static final String LOG_TAG = "Transition";
    private static final int MATCH_FIRST = 1;
    public static final int MATCH_ID = 3;
    private static final String MATCH_ID_STR = "id";
    public static final int MATCH_INSTANCE = 1;
    private static final String MATCH_INSTANCE_STR = "instance";
    public static final int MATCH_ITEM_ID = 4;
    private static final String MATCH_ITEM_ID_STR = "itemId";
    private static final int MATCH_LAST = 4;
    public static final int MATCH_NAME = 2;
    private static final String MATCH_NAME_STR = "name";
    private static final g STRAIGHT_PATH_MOTION = new g() {
        public Path a(float f, float f2, float f3, float f4) {
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f3, f4);
            return path;
        }
    };
    private static ThreadLocal<ArrayMap<Animator, a>> sRunningAnimators = new ThreadLocal<>();
    private ArrayList<Animator> mAnimators = new ArrayList<>();
    boolean mCanRemoveViews = false;
    ArrayList<Animator> mCurrentAnimators = new ArrayList<>();
    long mDuration = -1;
    private u mEndValues = new u();
    private ArrayList<t> mEndValuesList;
    private boolean mEnded = false;
    private c mEpicenterCallback;
    private TimeInterpolator mInterpolator = null;
    private ArrayList<d> mListeners = null;
    private int[] mMatchOrder = DEFAULT_MATCH_ORDER;
    private String mName = getClass().getName();
    private ArrayMap<String, String> mNameOverrides;
    private int mNumInstances = 0;
    q mParent = null;
    private g mPathMotion = STRAIGHT_PATH_MOTION;
    private boolean mPaused = false;
    p mPropagation;
    private ViewGroup mSceneRoot = null;
    private long mStartDelay = -1;
    private u mStartValues = new u();
    private ArrayList<t> mStartValuesList;
    private ArrayList<View> mTargetChildExcludes = null;
    private ArrayList<View> mTargetExcludes = null;
    private ArrayList<Integer> mTargetIdChildExcludes = null;
    private ArrayList<Integer> mTargetIdExcludes = null;
    ArrayList<Integer> mTargetIds = new ArrayList<>();
    private ArrayList<String> mTargetNameExcludes = null;
    private ArrayList<String> mTargetNames = null;
    private ArrayList<Class<?>> mTargetTypeChildExcludes = null;
    private ArrayList<Class<?>> mTargetTypeExcludes = null;
    private ArrayList<Class<?>> mTargetTypes = null;
    ArrayList<View> mTargets = new ArrayList<>();

    /* compiled from: Transition */
    public static abstract class c {
        public abstract Rect a(m mVar);
    }

    /* compiled from: Transition */
    public interface d {
        void a(m mVar);

        void b(m mVar);

        void c(m mVar);

        void d(m mVar);

        void e(m mVar);
    }

    private static boolean isValidMatch(int i) {
        return i >= 1 && i <= 4;
    }

    public abstract void captureEndValues(t tVar);

    public abstract void captureStartValues(t tVar);

    public Animator createAnimator(ViewGroup viewGroup, t tVar, t tVar2) {
        return null;
    }

    public String[] getTransitionProperties() {
        return null;
    }

    public m() {
    }

    @SuppressLint({"RestrictedApi"})
    public m(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.c);
        XmlResourceParser xmlResourceParser = (XmlResourceParser) attributeSet;
        long a2 = (long) g.a(obtainStyledAttributes, (XmlPullParser) xmlResourceParser, "duration", 1, -1);
        if (a2 >= 0) {
            setDuration(a2);
        }
        long a3 = (long) g.a(obtainStyledAttributes, (XmlPullParser) xmlResourceParser, "startDelay", 2, -1);
        if (a3 > 0) {
            setStartDelay(a3);
        }
        int c2 = g.c(obtainStyledAttributes, xmlResourceParser, "interpolator", 0, 0);
        if (c2 > 0) {
            setInterpolator(AnimationUtils.loadInterpolator(context, c2));
        }
        String a4 = g.a(obtainStyledAttributes, (XmlPullParser) xmlResourceParser, "matchOrder", 3);
        if (a4 != null) {
            setMatchOrder(parseMatchOrder(a4));
        }
        obtainStyledAttributes.recycle();
    }

    private static int[] parseMatchOrder(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        int[] iArr = new int[stringTokenizer.countTokens()];
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String trim = stringTokenizer.nextToken().trim();
            if (MATCH_ID_STR.equalsIgnoreCase(trim)) {
                iArr[i] = 3;
            } else if (MATCH_INSTANCE_STR.equalsIgnoreCase(trim)) {
                iArr[i] = 1;
            } else if (MATCH_NAME_STR.equalsIgnoreCase(trim)) {
                iArr[i] = 2;
            } else if (MATCH_ITEM_ID_STR.equalsIgnoreCase(trim)) {
                iArr[i] = 4;
            } else if (trim.isEmpty()) {
                int[] iArr2 = new int[(iArr.length - 1)];
                System.arraycopy(iArr, 0, iArr2, 0, i);
                i--;
                iArr = iArr2;
            } else {
                throw new InflateException("Unknown match type in matchOrder: '" + trim + "'");
            }
            i++;
        }
        return iArr;
    }

    public m setDuration(long j) {
        this.mDuration = j;
        return this;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public m setStartDelay(long j) {
        this.mStartDelay = j;
        return this;
    }

    public long getStartDelay() {
        return this.mStartDelay;
    }

    public m setInterpolator(TimeInterpolator timeInterpolator) {
        this.mInterpolator = timeInterpolator;
        return this;
    }

    public TimeInterpolator getInterpolator() {
        return this.mInterpolator;
    }

    public void setMatchOrder(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            this.mMatchOrder = DEFAULT_MATCH_ORDER;
            return;
        }
        int i = 0;
        while (i < iArr.length) {
            if (!isValidMatch(iArr[i])) {
                throw new IllegalArgumentException("matches contains invalid value");
            } else if (!alreadyContains(iArr, i)) {
                i++;
            } else {
                throw new IllegalArgumentException("matches contains a duplicate value");
            }
        }
        this.mMatchOrder = (int[]) iArr.clone();
    }

    private static boolean alreadyContains(int[] iArr, int i) {
        int i2 = iArr[i];
        for (int i3 = 0; i3 < i; i3++) {
            if (iArr[i3] == i2) {
                return true;
            }
        }
        return false;
    }

    private void matchInstances(ArrayMap<View, t> arrayMap, ArrayMap<View, t> arrayMap2) {
        t remove;
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            View keyAt = arrayMap.keyAt(size);
            if (keyAt != null && isValidTarget(keyAt) && (remove = arrayMap2.remove(keyAt)) != null && isValidTarget(remove.f1312b)) {
                this.mStartValuesList.add(arrayMap.removeAt(size));
                this.mEndValuesList.add(remove);
            }
        }
    }

    private void matchItemIds(ArrayMap<View, t> arrayMap, ArrayMap<View, t> arrayMap2, LongSparseArray<View> longSparseArray, LongSparseArray<View> longSparseArray2) {
        View view;
        int size = longSparseArray.size();
        for (int i = 0; i < size; i++) {
            View valueAt = longSparseArray.valueAt(i);
            if (valueAt != null && isValidTarget(valueAt) && (view = longSparseArray2.get(longSparseArray.keyAt(i))) != null && isValidTarget(view)) {
                t tVar = arrayMap.get(valueAt);
                t tVar2 = arrayMap2.get(view);
                if (!(tVar == null || tVar2 == null)) {
                    this.mStartValuesList.add(tVar);
                    this.mEndValuesList.add(tVar2);
                    arrayMap.remove(valueAt);
                    arrayMap2.remove(view);
                }
            }
        }
    }

    private void matchIds(ArrayMap<View, t> arrayMap, ArrayMap<View, t> arrayMap2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            View valueAt = sparseArray.valueAt(i);
            if (valueAt != null && isValidTarget(valueAt) && (view = sparseArray2.get(sparseArray.keyAt(i))) != null && isValidTarget(view)) {
                t tVar = arrayMap.get(valueAt);
                t tVar2 = arrayMap2.get(view);
                if (!(tVar == null || tVar2 == null)) {
                    this.mStartValuesList.add(tVar);
                    this.mEndValuesList.add(tVar2);
                    arrayMap.remove(valueAt);
                    arrayMap2.remove(view);
                }
            }
        }
    }

    private void matchNames(ArrayMap<View, t> arrayMap, ArrayMap<View, t> arrayMap2, ArrayMap<String, View> arrayMap3, ArrayMap<String, View> arrayMap4) {
        View view;
        int size = arrayMap3.size();
        for (int i = 0; i < size; i++) {
            View valueAt = arrayMap3.valueAt(i);
            if (valueAt != null && isValidTarget(valueAt) && (view = arrayMap4.get(arrayMap3.keyAt(i))) != null && isValidTarget(view)) {
                t tVar = arrayMap.get(valueAt);
                t tVar2 = arrayMap2.get(view);
                if (!(tVar == null || tVar2 == null)) {
                    this.mStartValuesList.add(tVar);
                    this.mEndValuesList.add(tVar2);
                    arrayMap.remove(valueAt);
                    arrayMap2.remove(view);
                }
            }
        }
    }

    private void addUnmatched(ArrayMap<View, t> arrayMap, ArrayMap<View, t> arrayMap2) {
        for (int i = 0; i < arrayMap.size(); i++) {
            t valueAt = arrayMap.valueAt(i);
            if (isValidTarget(valueAt.f1312b)) {
                this.mStartValuesList.add(valueAt);
                this.mEndValuesList.add((Object) null);
            }
        }
        for (int i2 = 0; i2 < arrayMap2.size(); i2++) {
            t valueAt2 = arrayMap2.valueAt(i2);
            if (isValidTarget(valueAt2.f1312b)) {
                this.mEndValuesList.add(valueAt2);
                this.mStartValuesList.add((Object) null);
            }
        }
    }

    private void matchStartAndEnd(u uVar, u uVar2) {
        ArrayMap arrayMap = new ArrayMap((SimpleArrayMap) uVar.f1313a);
        ArrayMap arrayMap2 = new ArrayMap((SimpleArrayMap) uVar2.f1313a);
        int i = 0;
        while (true) {
            int[] iArr = this.mMatchOrder;
            if (i < iArr.length) {
                int i2 = iArr[i];
                if (i2 == 1) {
                    matchInstances(arrayMap, arrayMap2);
                } else if (i2 == 2) {
                    matchNames(arrayMap, arrayMap2, uVar.d, uVar2.d);
                } else if (i2 == 3) {
                    matchIds(arrayMap, arrayMap2, uVar.f1314b, uVar2.f1314b);
                } else if (i2 == 4) {
                    matchItemIds(arrayMap, arrayMap2, uVar.c, uVar2.c);
                }
                i++;
            } else {
                addUnmatched(arrayMap, arrayMap2);
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void createAnimators(ViewGroup viewGroup, u uVar, u uVar2, ArrayList<t> arrayList, ArrayList<t> arrayList2) {
        int i;
        int i2;
        Animator createAnimator;
        View view;
        Animator animator;
        t tVar;
        t tVar2;
        Animator animator2;
        ViewGroup viewGroup2 = viewGroup;
        ArrayMap<Animator, a> runningAnimators = getRunningAnimators();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        long j = Long.MAX_VALUE;
        int i3 = 0;
        while (i3 < size) {
            t tVar3 = arrayList.get(i3);
            t tVar4 = arrayList2.get(i3);
            if (tVar3 != null && !tVar3.c.contains(this)) {
                tVar3 = null;
            }
            if (tVar4 != null && !tVar4.c.contains(this)) {
                tVar4 = null;
            }
            if (!(tVar3 == null && tVar4 == null)) {
                if ((tVar3 == null || tVar4 == null || isTransitionRequired(tVar3, tVar4)) && (createAnimator = createAnimator(viewGroup2, tVar3, tVar4)) != null) {
                    if (tVar4 != null) {
                        view = tVar4.f1312b;
                        String[] transitionProperties = getTransitionProperties();
                        if (transitionProperties != null && transitionProperties.length > 0) {
                            tVar2 = new t(view);
                            Animator animator3 = createAnimator;
                            i2 = size;
                            t tVar5 = uVar2.f1313a.get(view);
                            if (tVar5 != null) {
                                int i4 = 0;
                                while (i4 < transitionProperties.length) {
                                    tVar2.f1311a.put(transitionProperties[i4], tVar5.f1311a.get(transitionProperties[i4]));
                                    i4++;
                                    ArrayList<t> arrayList3 = arrayList2;
                                    i3 = i3;
                                    tVar5 = tVar5;
                                }
                            }
                            i = i3;
                            int size2 = runningAnimators.size();
                            int i5 = 0;
                            while (true) {
                                if (i5 >= size2) {
                                    animator2 = animator3;
                                    break;
                                }
                                a aVar = runningAnimators.get(runningAnimators.keyAt(i5));
                                if (aVar.c != null && aVar.f1296a == view && aVar.f1297b.equals(getName()) && aVar.c.equals(tVar2)) {
                                    animator2 = null;
                                    break;
                                }
                                i5++;
                            }
                        } else {
                            i2 = size;
                            i = i3;
                            animator2 = createAnimator;
                            tVar2 = null;
                        }
                        animator = animator2;
                        tVar = tVar2;
                    } else {
                        i2 = size;
                        i = i3;
                        view = tVar3.f1312b;
                        animator = createAnimator;
                        tVar = null;
                    }
                    if (animator != null) {
                        p pVar = this.mPropagation;
                        if (pVar != null) {
                            long a2 = pVar.a(viewGroup2, this, tVar3, tVar4);
                            sparseIntArray.put(this.mAnimators.size(), (int) a2);
                            j = Math.min(a2, j);
                        }
                        runningAnimators.put(animator, new a(view, getName(), this, ad.b(viewGroup), tVar));
                        this.mAnimators.add(animator);
                        j = j;
                    }
                    i3 = i + 1;
                    size = i2;
                }
            }
            i2 = size;
            i = i3;
            i3 = i + 1;
            size = i2;
        }
        if (sparseIntArray.size() != 0) {
            for (int i6 = 0; i6 < sparseIntArray.size(); i6++) {
                Animator animator4 = this.mAnimators.get(sparseIntArray.keyAt(i6));
                animator4.setStartDelay((((long) sparseIntArray.valueAt(i6)) - j) + animator4.getStartDelay());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isValidTarget(View view) {
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        int id = view.getId();
        ArrayList<Integer> arrayList3 = this.mTargetIdExcludes;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.mTargetExcludes;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class<?>> arrayList5 = this.mTargetTypeExcludes;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i = 0; i < size; i++) {
                if (this.mTargetTypeExcludes.get(i).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.mTargetNameExcludes != null && v.q(view) != null && this.mTargetNameExcludes.contains(v.q(view))) {
            return false;
        }
        if ((this.mTargetIds.size() == 0 && this.mTargets.size() == 0 && (((arrayList = this.mTargetTypes) == null || arrayList.isEmpty()) && ((arrayList2 = this.mTargetNames) == null || arrayList2.isEmpty()))) || this.mTargetIds.contains(Integer.valueOf(id)) || this.mTargets.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.mTargetNames;
        if (arrayList6 != null && arrayList6.contains(v.q(view))) {
            return true;
        }
        if (this.mTargetTypes != null) {
            for (int i2 = 0; i2 < this.mTargetTypes.size(); i2++) {
                if (this.mTargetTypes.get(i2).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static ArrayMap<Animator, a> getRunningAnimators() {
        ArrayMap<Animator, a> arrayMap = sRunningAnimators.get();
        if (arrayMap != null) {
            return arrayMap;
        }
        ArrayMap<Animator, a> arrayMap2 = new ArrayMap<>();
        sRunningAnimators.set(arrayMap2);
        return arrayMap2;
    }

    /* access modifiers changed from: protected */
    public void runAnimators() {
        start();
        ArrayMap<Animator, a> runningAnimators = getRunningAnimators();
        Iterator<Animator> it = this.mAnimators.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (runningAnimators.containsKey(next)) {
                start();
                runAnimator(next, runningAnimators);
            }
        }
        this.mAnimators.clear();
        end();
    }

    private void runAnimator(Animator animator, final ArrayMap<Animator, a> arrayMap) {
        if (animator != null) {
            animator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    m.this.mCurrentAnimators.add(animator);
                }

                public void onAnimationEnd(Animator animator) {
                    arrayMap.remove(animator);
                    m.this.mCurrentAnimators.remove(animator);
                }
            });
            animate(animator);
        }
    }

    public m addTarget(View view) {
        this.mTargets.add(view);
        return this;
    }

    public m addTarget(int i) {
        if (i != 0) {
            this.mTargetIds.add(Integer.valueOf(i));
        }
        return this;
    }

    public m addTarget(String str) {
        if (this.mTargetNames == null) {
            this.mTargetNames = new ArrayList<>();
        }
        this.mTargetNames.add(str);
        return this;
    }

    public m addTarget(Class<?> cls) {
        if (this.mTargetTypes == null) {
            this.mTargetTypes = new ArrayList<>();
        }
        this.mTargetTypes.add(cls);
        return this;
    }

    public m removeTarget(View view) {
        this.mTargets.remove(view);
        return this;
    }

    public m removeTarget(int i) {
        if (i != 0) {
            this.mTargetIds.remove(Integer.valueOf(i));
        }
        return this;
    }

    public m removeTarget(String str) {
        ArrayList<String> arrayList = this.mTargetNames;
        if (arrayList != null) {
            arrayList.remove(str);
        }
        return this;
    }

    public m removeTarget(Class<?> cls) {
        ArrayList<Class<?>> arrayList = this.mTargetTypes;
        if (arrayList != null) {
            arrayList.remove(cls);
        }
        return this;
    }

    private static <T> ArrayList<T> excludeObject(ArrayList<T> arrayList, T t, boolean z) {
        if (t == null) {
            return arrayList;
        }
        if (z) {
            return b.a(arrayList, t);
        }
        return b.b(arrayList, t);
    }

    public m excludeTarget(View view, boolean z) {
        this.mTargetExcludes = excludeView(this.mTargetExcludes, view, z);
        return this;
    }

    public m excludeTarget(int i, boolean z) {
        this.mTargetIdExcludes = excludeId(this.mTargetIdExcludes, i, z);
        return this;
    }

    public m excludeTarget(String str, boolean z) {
        this.mTargetNameExcludes = excludeObject(this.mTargetNameExcludes, str, z);
        return this;
    }

    public m excludeChildren(View view, boolean z) {
        this.mTargetChildExcludes = excludeView(this.mTargetChildExcludes, view, z);
        return this;
    }

    public m excludeChildren(int i, boolean z) {
        this.mTargetIdChildExcludes = excludeId(this.mTargetIdChildExcludes, i, z);
        return this;
    }

    private ArrayList<Integer> excludeId(ArrayList<Integer> arrayList, int i, boolean z) {
        if (i <= 0) {
            return arrayList;
        }
        if (z) {
            return b.a(arrayList, Integer.valueOf(i));
        }
        return b.b(arrayList, Integer.valueOf(i));
    }

    private ArrayList<View> excludeView(ArrayList<View> arrayList, View view, boolean z) {
        if (view == null) {
            return arrayList;
        }
        if (z) {
            return b.a(arrayList, view);
        }
        return b.b(arrayList, view);
    }

    public m excludeTarget(Class<?> cls, boolean z) {
        this.mTargetTypeExcludes = excludeType(this.mTargetTypeExcludes, cls, z);
        return this;
    }

    public m excludeChildren(Class<?> cls, boolean z) {
        this.mTargetTypeChildExcludes = excludeType(this.mTargetTypeChildExcludes, cls, z);
        return this;
    }

    private ArrayList<Class<?>> excludeType(ArrayList<Class<?>> arrayList, Class<?> cls, boolean z) {
        if (cls == null) {
            return arrayList;
        }
        if (z) {
            return b.a(arrayList, cls);
        }
        return b.b(arrayList, cls);
    }

    public List<Integer> getTargetIds() {
        return this.mTargetIds;
    }

    public List<View> getTargets() {
        return this.mTargets;
    }

    public List<String> getTargetNames() {
        return this.mTargetNames;
    }

    public List<Class<?>> getTargetTypes() {
        return this.mTargetTypes;
    }

    /* access modifiers changed from: package-private */
    public void captureValues(ViewGroup viewGroup, boolean z) {
        ArrayMap<String, String> arrayMap;
        ArrayList<String> arrayList;
        ArrayList<Class<?>> arrayList2;
        clearValues(z);
        if ((this.mTargetIds.size() > 0 || this.mTargets.size() > 0) && (((arrayList = this.mTargetNames) == null || arrayList.isEmpty()) && ((arrayList2 = this.mTargetTypes) == null || arrayList2.isEmpty()))) {
            for (int i = 0; i < this.mTargetIds.size(); i++) {
                View findViewById = viewGroup.findViewById(this.mTargetIds.get(i).intValue());
                if (findViewById != null) {
                    t tVar = new t(findViewById);
                    if (z) {
                        captureStartValues(tVar);
                    } else {
                        captureEndValues(tVar);
                    }
                    tVar.c.add(this);
                    capturePropagationValues(tVar);
                    if (z) {
                        addViewValues(this.mStartValues, findViewById, tVar);
                    } else {
                        addViewValues(this.mEndValues, findViewById, tVar);
                    }
                }
            }
            for (int i2 = 0; i2 < this.mTargets.size(); i2++) {
                View view = this.mTargets.get(i2);
                t tVar2 = new t(view);
                if (z) {
                    captureStartValues(tVar2);
                } else {
                    captureEndValues(tVar2);
                }
                tVar2.c.add(this);
                capturePropagationValues(tVar2);
                if (z) {
                    addViewValues(this.mStartValues, view, tVar2);
                } else {
                    addViewValues(this.mEndValues, view, tVar2);
                }
            }
        } else {
            captureHierarchy(viewGroup, z);
        }
        if (!z && (arrayMap = this.mNameOverrides) != null) {
            int size = arrayMap.size();
            ArrayList arrayList3 = new ArrayList(size);
            for (int i3 = 0; i3 < size; i3++) {
                arrayList3.add(this.mStartValues.d.remove(this.mNameOverrides.keyAt(i3)));
            }
            for (int i4 = 0; i4 < size; i4++) {
                View view2 = (View) arrayList3.get(i4);
                if (view2 != null) {
                    this.mStartValues.d.put(this.mNameOverrides.valueAt(i4), view2);
                }
            }
        }
    }

    private static void addViewValues(u uVar, View view, t tVar) {
        uVar.f1313a.put(view, tVar);
        int id = view.getId();
        if (id >= 0) {
            if (uVar.f1314b.indexOfKey(id) >= 0) {
                uVar.f1314b.put(id, (Object) null);
            } else {
                uVar.f1314b.put(id, view);
            }
        }
        String q = v.q(view);
        if (q != null) {
            if (uVar.d.containsKey(q)) {
                uVar.d.put(q, null);
            } else {
                uVar.d.put(q, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (uVar.c.indexOfKey(itemIdAtPosition) >= 0) {
                    View view2 = uVar.c.get(itemIdAtPosition);
                    if (view2 != null) {
                        v.a(view2, false);
                        uVar.c.put(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                v.a(view, true);
                uVar.c.put(itemIdAtPosition, view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void clearValues(boolean z) {
        if (z) {
            this.mStartValues.f1313a.clear();
            this.mStartValues.f1314b.clear();
            this.mStartValues.c.clear();
            return;
        }
        this.mEndValues.f1313a.clear();
        this.mEndValues.f1314b.clear();
        this.mEndValues.c.clear();
    }

    private void captureHierarchy(View view, boolean z) {
        if (view != null) {
            int id = view.getId();
            ArrayList<Integer> arrayList = this.mTargetIdExcludes;
            if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
                ArrayList<View> arrayList2 = this.mTargetExcludes;
                if (arrayList2 == null || !arrayList2.contains(view)) {
                    ArrayList<Class<?>> arrayList3 = this.mTargetTypeExcludes;
                    if (arrayList3 != null) {
                        int size = arrayList3.size();
                        int i = 0;
                        while (i < size) {
                            if (!this.mTargetTypeExcludes.get(i).isInstance(view)) {
                                i++;
                            } else {
                                return;
                            }
                        }
                    }
                    if (view.getParent() instanceof ViewGroup) {
                        t tVar = new t(view);
                        if (z) {
                            captureStartValues(tVar);
                        } else {
                            captureEndValues(tVar);
                        }
                        tVar.c.add(this);
                        capturePropagationValues(tVar);
                        if (z) {
                            addViewValues(this.mStartValues, view, tVar);
                        } else {
                            addViewValues(this.mEndValues, view, tVar);
                        }
                    }
                    if (view instanceof ViewGroup) {
                        ArrayList<Integer> arrayList4 = this.mTargetIdChildExcludes;
                        if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                            ArrayList<View> arrayList5 = this.mTargetChildExcludes;
                            if (arrayList5 == null || !arrayList5.contains(view)) {
                                ArrayList<Class<?>> arrayList6 = this.mTargetTypeChildExcludes;
                                if (arrayList6 != null) {
                                    int size2 = arrayList6.size();
                                    int i2 = 0;
                                    while (i2 < size2) {
                                        if (!this.mTargetTypeChildExcludes.get(i2).isInstance(view)) {
                                            i2++;
                                        } else {
                                            return;
                                        }
                                    }
                                }
                                ViewGroup viewGroup = (ViewGroup) view;
                                for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                                    captureHierarchy(viewGroup.getChildAt(i3), z);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public t getTransitionValues(View view, boolean z) {
        q qVar = this.mParent;
        if (qVar != null) {
            return qVar.getTransitionValues(view, z);
        }
        return (z ? this.mStartValues : this.mEndValues).f1313a.get(view);
    }

    /* access modifiers changed from: package-private */
    public t getMatchedTransitionValues(View view, boolean z) {
        q qVar = this.mParent;
        if (qVar != null) {
            return qVar.getMatchedTransitionValues(view, z);
        }
        ArrayList<t> arrayList = z ? this.mStartValuesList : this.mEndValuesList;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i = -1;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            t tVar = arrayList.get(i2);
            if (tVar == null) {
                return null;
            }
            if (tVar.f1312b == view) {
                i = i2;
                break;
            }
            i2++;
        }
        if (i < 0) {
            return null;
        }
        return (z ? this.mEndValuesList : this.mStartValuesList).get(i);
    }

    public void pause(View view) {
        if (!this.mEnded) {
            ArrayMap<Animator, a> runningAnimators = getRunningAnimators();
            int size = runningAnimators.size();
            an b2 = ad.b(view);
            for (int i = size - 1; i >= 0; i--) {
                a valueAt = runningAnimators.valueAt(i);
                if (valueAt.f1296a != null && b2.equals(valueAt.d)) {
                    a.a(runningAnimators.keyAt(i));
                }
            }
            ArrayList<d> arrayList = this.mListeners;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                int size2 = arrayList2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    ((d) arrayList2.get(i2)).c(this);
                }
            }
            this.mPaused = true;
        }
    }

    public void resume(View view) {
        if (this.mPaused) {
            if (!this.mEnded) {
                ArrayMap<Animator, a> runningAnimators = getRunningAnimators();
                int size = runningAnimators.size();
                an b2 = ad.b(view);
                for (int i = size - 1; i >= 0; i--) {
                    a valueAt = runningAnimators.valueAt(i);
                    if (valueAt.f1296a != null && b2.equals(valueAt.d)) {
                        a.b(runningAnimators.keyAt(i));
                    }
                }
                ArrayList<d> arrayList = this.mListeners;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                    int size2 = arrayList2.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ((d) arrayList2.get(i2)).d(this);
                    }
                }
            }
            this.mPaused = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void playTransition(ViewGroup viewGroup) {
        a aVar;
        this.mStartValuesList = new ArrayList<>();
        this.mEndValuesList = new ArrayList<>();
        matchStartAndEnd(this.mStartValues, this.mEndValues);
        ArrayMap<Animator, a> runningAnimators = getRunningAnimators();
        int size = runningAnimators.size();
        an b2 = ad.b(viewGroup);
        for (int i = size - 1; i >= 0; i--) {
            Animator keyAt = runningAnimators.keyAt(i);
            if (!(keyAt == null || (aVar = runningAnimators.get(keyAt)) == null || aVar.f1296a == null || !b2.equals(aVar.d))) {
                t tVar = aVar.c;
                View view = aVar.f1296a;
                t transitionValues = getTransitionValues(view, true);
                t matchedTransitionValues = getMatchedTransitionValues(view, true);
                if (transitionValues == null && matchedTransitionValues == null) {
                    matchedTransitionValues = this.mEndValues.f1313a.get(view);
                }
                if (!(transitionValues == null && matchedTransitionValues == null) && aVar.e.isTransitionRequired(tVar, matchedTransitionValues)) {
                    if (keyAt.isRunning() || keyAt.isStarted()) {
                        keyAt.cancel();
                    } else {
                        runningAnimators.remove(keyAt);
                    }
                }
            }
        }
        createAnimators(viewGroup, this.mStartValues, this.mEndValues, this.mStartValuesList, this.mEndValuesList);
        runAnimators();
    }

    public boolean isTransitionRequired(t tVar, t tVar2) {
        if (tVar == null || tVar2 == null) {
            return false;
        }
        String[] transitionProperties = getTransitionProperties();
        if (transitionProperties != null) {
            int length = transitionProperties.length;
            int i = 0;
            while (i < length) {
                if (!isValueChanged(tVar, tVar2, transitionProperties[i])) {
                    i++;
                }
            }
            return false;
        }
        for (String isValueChanged : tVar.f1311a.keySet()) {
            if (isValueChanged(tVar, tVar2, isValueChanged)) {
            }
        }
        return false;
        return true;
    }

    private static boolean isValueChanged(t tVar, t tVar2, String str) {
        Object obj = tVar.f1311a.get(str);
        Object obj2 = tVar2.f1311a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    /* access modifiers changed from: protected */
    public void animate(Animator animator) {
        if (animator == null) {
            end();
            return;
        }
        if (getDuration() >= 0) {
            animator.setDuration(getDuration());
        }
        if (getStartDelay() >= 0) {
            animator.setStartDelay(getStartDelay() + animator.getStartDelay());
        }
        if (getInterpolator() != null) {
            animator.setInterpolator(getInterpolator());
        }
        animator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                m.this.end();
                animator.removeListener(this);
            }
        });
        animator.start();
    }

    /* access modifiers changed from: protected */
    public void start() {
        if (this.mNumInstances == 0) {
            ArrayList<d> arrayList = this.mListeners;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    ((d) arrayList2.get(i)).e(this);
                }
            }
            this.mEnded = false;
        }
        this.mNumInstances++;
    }

    /* access modifiers changed from: protected */
    public void end() {
        this.mNumInstances--;
        if (this.mNumInstances == 0) {
            ArrayList<d> arrayList = this.mListeners;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    ((d) arrayList2.get(i)).b(this);
                }
            }
            for (int i2 = 0; i2 < this.mStartValues.c.size(); i2++) {
                View valueAt = this.mStartValues.c.valueAt(i2);
                if (valueAt != null) {
                    v.a(valueAt, false);
                }
            }
            for (int i3 = 0; i3 < this.mEndValues.c.size(); i3++) {
                View valueAt2 = this.mEndValues.c.valueAt(i3);
                if (valueAt2 != null) {
                    v.a(valueAt2, false);
                }
            }
            this.mEnded = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void forceToEnd(ViewGroup viewGroup) {
        ArrayMap<Animator, a> runningAnimators = getRunningAnimators();
        int size = runningAnimators.size();
        if (viewGroup != null && size != 0) {
            an b2 = ad.b(viewGroup);
            ArrayMap arrayMap = new ArrayMap((SimpleArrayMap) runningAnimators);
            runningAnimators.clear();
            for (int i = size - 1; i >= 0; i--) {
                a aVar = (a) arrayMap.valueAt(i);
                if (!(aVar.f1296a == null || b2 == null || !b2.equals(aVar.d))) {
                    ((Animator) arrayMap.keyAt(i)).end();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void cancel() {
        for (int size = this.mCurrentAnimators.size() - 1; size >= 0; size--) {
            this.mCurrentAnimators.get(size).cancel();
        }
        ArrayList<d> arrayList = this.mListeners;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
            int size2 = arrayList2.size();
            for (int i = 0; i < size2; i++) {
                ((d) arrayList2.get(i)).a(this);
            }
        }
    }

    public m addListener(d dVar) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<>();
        }
        this.mListeners.add(dVar);
        return this;
    }

    public m removeListener(d dVar) {
        ArrayList<d> arrayList = this.mListeners;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(dVar);
        if (this.mListeners.size() == 0) {
            this.mListeners = null;
        }
        return this;
    }

    public void setPathMotion(g gVar) {
        if (gVar == null) {
            this.mPathMotion = STRAIGHT_PATH_MOTION;
        } else {
            this.mPathMotion = gVar;
        }
    }

    public g getPathMotion() {
        return this.mPathMotion;
    }

    public void setEpicenterCallback(c cVar) {
        this.mEpicenterCallback = cVar;
    }

    public c getEpicenterCallback() {
        return this.mEpicenterCallback;
    }

    public Rect getEpicenter() {
        c cVar = this.mEpicenterCallback;
        if (cVar == null) {
            return null;
        }
        return cVar.a(this);
    }

    public void setPropagation(p pVar) {
        this.mPropagation = pVar;
    }

    public p getPropagation() {
        return this.mPropagation;
    }

    /* access modifiers changed from: package-private */
    public void capturePropagationValues(t tVar) {
        String[] a2;
        if (this.mPropagation != null && !tVar.f1311a.isEmpty() && (a2 = this.mPropagation.a()) != null) {
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= a2.length) {
                    z = true;
                    break;
                } else if (!tVar.f1311a.containsKey(a2[i])) {
                    break;
                } else {
                    i++;
                }
            }
            if (!z) {
                this.mPropagation.a(tVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public m setSceneRoot(ViewGroup viewGroup) {
        this.mSceneRoot = viewGroup;
        return this;
    }

    /* access modifiers changed from: package-private */
    public void setCanRemoveViews(boolean z) {
        this.mCanRemoveViews = z;
    }

    public String toString() {
        return toString("");
    }

    public m clone() {
        try {
            m mVar = (m) super.clone();
            mVar.mAnimators = new ArrayList<>();
            mVar.mStartValues = new u();
            mVar.mEndValues = new u();
            mVar.mStartValuesList = null;
            mVar.mEndValuesList = null;
            return mVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public String getName() {
        return this.mName;
    }

    /* access modifiers changed from: package-private */
    public String toString(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.mDuration != -1) {
            str2 = str2 + "dur(" + this.mDuration + ") ";
        }
        if (this.mStartDelay != -1) {
            str2 = str2 + "dly(" + this.mStartDelay + ") ";
        }
        if (this.mInterpolator != null) {
            str2 = str2 + "interp(" + this.mInterpolator + ") ";
        }
        if (this.mTargetIds.size() <= 0 && this.mTargets.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.mTargetIds.size() > 0) {
            String str4 = str3;
            for (int i = 0; i < this.mTargetIds.size(); i++) {
                if (i > 0) {
                    str4 = str4 + ", ";
                }
                str4 = str4 + this.mTargetIds.get(i);
            }
            str3 = str4;
        }
        if (this.mTargets.size() > 0) {
            for (int i2 = 0; i2 < this.mTargets.size(); i2++) {
                if (i2 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.mTargets.get(i2);
            }
        }
        return str3 + ")";
    }

    /* compiled from: Transition */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        View f1296a;

        /* renamed from: b  reason: collision with root package name */
        String f1297b;
        t c;
        an d;
        m e;

        a(View view, String str, m mVar, an anVar, t tVar) {
            this.f1296a = view;
            this.f1297b = str;
            this.c = tVar;
            this.d = anVar;
            this.e = mVar;
        }
    }

    /* compiled from: Transition */
    private static class b {
        static <T> ArrayList<T> a(ArrayList<T> arrayList, T t) {
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            if (!arrayList.contains(t)) {
                arrayList.add(t);
            }
            return arrayList;
        }

        static <T> ArrayList<T> b(ArrayList<T> arrayList, T t) {
            if (arrayList == null) {
                return arrayList;
            }
            arrayList.remove(t);
            if (arrayList.isEmpty()) {
                return null;
            }
            return arrayList;
        }
    }
}
