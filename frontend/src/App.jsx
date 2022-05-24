import {BrowserRouter, Routes, Route} from "react-router-dom";
import Home from "./pages/Home";
import "./styles/tw.output.css";
import ArticleList from "./pages/article/list";

function App() {

    return (
        <BrowserRouter>
            <Routes>
                <Route index element={<Home />} />
                <Route path="/article/list" element={<ArticleList />} />
            </Routes>
        </BrowserRouter>
    );
}

export default App;
