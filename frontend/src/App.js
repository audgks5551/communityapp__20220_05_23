import {useEffect, useState} from "react";
import axios from "axios";
import UserService from "./service/UserService";

function App() {
    const token = UserService.getToken();
    const [data, setData] = useState({});

    useEffect(() => {

        (async () => {
            await axios.get("/test", {
                headers: {
                    Authorization: `Bearer ${token}`
                }
            })
                .then(({data}) => {
                    setData(data)
                    console.log(data)
                });
        })();
    },[]);

    return (
        <>
            <h1>{data.username}</h1>
            <h1>{data.password}</h1>
            <h1>{data.token}</h1>
        </>
    );
}

export default App;
