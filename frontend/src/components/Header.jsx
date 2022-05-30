import UserService from "../libs/UserService";
import RenderOnAnonymous from "./RenderOnAnonymous";
import RenderOnAuthenticated from "./RenderOnAuthenticated";
import {Link} from "react-router-dom";

export default function Header() {
    const onClickLogin = () => UserService.doLogin()
    const onClickLogout = () => UserService.doLogout()
    const onClickSignup = () => UserService.doSignup();
    const nickName = UserService.isLoggedIn() && UserService.getNickName()

    return (
        <>
            <div className="flex justify-between px-20 py-5">
                <div className="space-x-8">
                    <Link to="/" ><span className="text-2xl">Article</span></Link>
                    <Link to="/article"><span className="text-lg select-none">list</span></Link>
                    <Link to="/article/new"><span className="text-lg select-none">create</span></Link>
                </div>
                <div className="flex space-x-4 items-center">
                    <RenderOnAnonymous>
                        <button onClick={onClickLogin} className="text-lg">Login</button>
                        <button onClick={onClickSignup} className="text-lg">Signup</button>
                    </RenderOnAnonymous>
                    <RenderOnAuthenticated>
                        <div className="border-2 p-2 rounded-xl border-teal-500 select-none">
                            <span className="text-teal-700 cursor-pointer  hover:text-teal-500 mr-1">{nickName}</span>
                            <span>님 환영합니다</span>
                        </div>
                        <button onClick={onClickLogout} className="text-lg">Logout</button>
                    </RenderOnAuthenticated>
                </div>
            </div>
        </>
    );
}