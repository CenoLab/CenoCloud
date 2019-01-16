import { RouteReuseStrategy, DefaultUrlSerializer, ActivatedRouteSnapshot, DetachedRouteHandle } from '@angular/router';
import { Cookie } from 'ng2-cookies/ng2-cookies';

export class SimpleReuseStrategy implements RouteReuseStrategy {

    private index_scroll:any;

    public static handlers: { [key: string]: DetachedRouteHandle } = {}

    private static waitDelete:string

    /** 表示对所有路由允许复用 如果你有路由不想利用可以在这加一些业务逻辑判断 */
    public shouldDetach(route: ActivatedRouteSnapshot): boolean {
        if(route.routeConfig.path=="index"||route.routeConfig.path.search("article")!=-1){
            return true;
        }
        return false;
        //return true;
    }

    /** 当路由离开时会触发。按path作为key存储路由快照&组件当前实例对象 */
    public store(route: ActivatedRouteSnapshot, handle: DetachedRouteHandle): void {
        if(route.routeConfig.path=="index"&&handle!=null){
            $(".moblie-menu").removeClass("dark2");
            Cookie.set("lzw",$("#forum").data("lzw"),null,"/");
            Cookie.set("lzwState","true",null,"/");
        }
        if(SimpleReuseStrategy.waitDelete && SimpleReuseStrategy.waitDelete==this.getRouteUrl(route)){
            //如果待删除是当前路由则不存储快照
            SimpleReuseStrategy.waitDelete=null
            return;
        }
        SimpleReuseStrategy.handlers[this.getRouteUrl(route)] = handle
    }

    /** 若 path 在缓存中有的都认为允许还原路由 */
    public shouldAttach(route: ActivatedRouteSnapshot): boolean {
        return !!SimpleReuseStrategy.handlers[this.getRouteUrl(route)];
    }

    /** 从缓存中获取快照，若无则返回nul */
    public retrieve(route: ActivatedRouteSnapshot): DetachedRouteHandle {
        if (!route.routeConfig) {
            return null
        }
        
        return SimpleReuseStrategy.handlers[this.getRouteUrl(route)]
    }

    /** 进入路由触发，判断是否同一路由 */
    public shouldReuseRoute(future: ActivatedRouteSnapshot, curr: ActivatedRouteSnapshot): boolean {
        return future.routeConfig===curr.routeConfig && 
            JSON.stringify(future.params)==JSON.stringify(curr.params);
    }

    private getRouteUrl(route: ActivatedRouteSnapshot){
        return route['_routerState'].url.replace(/\//g,'_')
    }

    public static deleteRouteSnapshot(name:string):void{
        if(SimpleReuseStrategy.handlers[name]){
            delete SimpleReuseStrategy.handlers[name];
        }else{
            SimpleReuseStrategy.waitDelete=name;
        }
    }
}