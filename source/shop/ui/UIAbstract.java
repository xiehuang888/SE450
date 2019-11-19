package shop.ui;

abstract class UIAbstract implements UIFormable{

    protected final String _heading;
    protected final Pair[] _form;

    static class Pair<K,V> {

        final K prompt;
        final V test;

        Pair(K thePrompt, V theTest) {
            prompt = thePrompt;
            test = theTest;
        }
    }

    UIAbstract(String heading, Pair[] menu) {
        _heading = heading;
        _form = menu;
    }
    public int size() {
        return _form.length;
    }
    public String getHeading() {
        return _heading;
    }
    public String getPrompt(int i) {
        return (String)_form[i].prompt;
    }

}
