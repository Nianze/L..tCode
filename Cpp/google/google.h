class MGoogle;

class Google
{
public:
    Google(MGoogle& m_google);
    bool foo(bool useDui);
protected:
    MGoogle& m_google;
};
