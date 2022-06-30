import { RecoilRoot } from 'recoil';
import {BrowserRouter, Route, Routes} from "react-router-dom";

import Home from "./pages/Home";
import ArticleList from "./pages/article/list";
import CreateArticle from "./pages/article/create";

import "./styles/tw.output.css";

function App() {
    return (
        <RecoilRoot>
            <BrowserRouter>
                <Routes>
                    <Route index element={<Home />} />
                    <Route path="/article" element={<ArticleList />} />
                    <Route path="/article/new" element={<CreateArticle />} />
                </Routes>
            </BrowserRouter>
        </RecoilRoot>
    );
}

export default App;
