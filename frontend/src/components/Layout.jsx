import Header from "./Header";

const Layout = ({ children }) => {

    return (
        <>
            <Header/>
            <div className="ml-[410px] min-h-screen px-56">{children}</div>
        </>
    );
}

export default Layout;