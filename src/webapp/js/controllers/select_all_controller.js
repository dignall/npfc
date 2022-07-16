import {Controller} from "stimulus";

export default class SelectAllController extends Controller {
    static get targets() {
        return ["selectable"];
    }

    selectAll() {
        const allTargets = this.selectableTargets
        if (allTargets.filter(it => !it.checked).length === 0) {
            allTargets.forEach(el => el.checked = false);
        } else {
            allTargets.forEach(el => el.checked = true);
        }
    }
}
