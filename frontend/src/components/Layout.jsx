import Header from "./Header";


export default function Layout({ children }) {

    return (
        <>
            <Header/>
            <div className="ml-[410px] min-h-screen px-56">{children}</div>

        </>

    );
}