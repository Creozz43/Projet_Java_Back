import{c as l,j as s}from"./index-B3EVoAhT.js";/**
 * @license lucide-react v0.344.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const c=l("AlertCircle",[["circle",{cx:"12",cy:"12",r:"10",key:"1mglay"}],["line",{x1:"12",x2:"12",y1:"8",y2:"12",key:"1pkeuh"}],["line",{x1:"12",x2:"12.01",y1:"16",y2:"16",key:"4dfq90"}]]);/**
 * @license lucide-react v0.344.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const r=l("CheckCircle",[["path",{d:"M22 11.08V12a10 10 0 1 1-5.93-9.14",key:"g774vq"}],["path",{d:"m9 11 3 3L22 4",key:"1pflzl"}]]);/**
 * @license lucide-react v0.344.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const d=l("Play",[["polygon",{points:"5 3 19 12 5 21 5 3",key:"191637"}]]);function m({endpoint:e,onTest:t}){return s.jsxs("div",{className:"bg-white p-4 rounded-lg shadow-md flex items-center justify-between",children:[s.jsxs("div",{children:[s.jsxs("div",{className:"flex items-center space-x-2",children:[s.jsx("span",{className:`px-2 py-1 rounded text-sm font-medium ${e.method==="GET"?"bg-blue-100 text-blue-800":e.method==="POST"?"bg-green-100 text-green-800":e.method==="PUT"?"bg-yellow-100 text-yellow-800":"bg-red-100 text-red-800"}`,children:e.method}),s.jsx("span",{className:"font-mono",children:e.path})]}),s.jsx("p",{className:"text-gray-600 mt-1",children:e.description}),e.validationResult&&s.jsxs("div",{className:`mt-2 p-2 rounded text-sm ${e.validationResult.valid?"bg-green-50 text-green-800":"bg-red-50 text-red-800"}`,children:[s.jsx("p",{children:e.validationResult.message}),e.validationResult.details&&e.validationResult.details.length>0&&s.jsxs("ul",{className:"mt-1 list-disc list-inside",children:[e.validationResult.details.slice(0,3).map((a,i)=>s.jsx("li",{children:a},i)),e.validationResult.details.length>3&&s.jsxs("li",{children:["... et ",e.validationResult.details.length-3," autre(s) erreur(s)"]})]})]})]}),s.jsxs("div",{className:"flex items-center space-x-4",children:[e.status==="success"&&s.jsx(r,{className:"text-green-500 h-5 w-5"}),e.status==="failed"&&s.jsx(c,{className:"text-red-500 h-5 w-5"}),s.jsxs("button",{onClick:()=>t(e),className:"flex items-center space-x-1 px-3 py-1 bg-green-600 text-white rounded-md hover:bg-green-700",children:[s.jsx(d,{className:"h-4 w-4"}),s.jsx("span",{children:"Test"})]})]})]})}export{m as default};
