namespace java com.xwt.thrift.view
namespace py view.api

typedef string String

service ViewService{
    String getView(1:String filename);
    bool ttt(1:String t1);
}