import Header from "./Header";

const Layout = ({ children }) => {

    return (
        <>
            <Header/>
            <div className="ml-[320px] min-h-screen">{children}</div>
        </>
    );
}

export default Layout;