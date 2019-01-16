import { Headers } from '@angular/http';
import { Cookie } from 'ng2-cookies/ng2-cookies'


export class ApiService {

    private uid = (this.getCookie("uid")==null)?"0":this.getCookie("uid");
    private token =(this.getCookie("token")==null)?"0":this.getCookie("token");
    private authorId = Number(this.getCookie("authorId"));

    constructor() {
		if ((this.uid != null && this.token != null)&&(this.uid!="0"&&this.token!="0")) {
		} else {
			Cookie.set("uid","0",null,'/','cenocloud.com');
			Cookie.set("token","0",null,'/','cenocloud.com');
			//window.location.href="https://www.cenocloud.com/login.html";
        }
        this.uid = (this.getCookie("uid")==null)?"0":this.getCookie("uid");
        this.token = (this.getCookie("token")==null)?"0":this.getCookie("token");
    }

    getUrl(): string {
        return 'https://api.forum.cenocloud.com/api/v1';
        //return 'api/v1';
    }
    getHeaders(): Headers {
        return new Headers({ 'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8',
         'FromAgent': 'Broswer' ,
         'SSO-ID': this.uid,
         'SSO-TOKEN':this.token
        });
    }
    getHeaders1(): Headers {
        return new Headers({ 'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8',
         'FromAgent': 'Broswer' ,
        });
    }

    getCookie(name: string): String {
        return Cookie.get(name);
    }

    setCookie(c_name, value) {
        Cookie.set(c_name,value,null,'/')
    }
}
